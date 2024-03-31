import requests
import json
import csv
import datetime

URL = "https://api.the-finals-leaderboard.com/v1/leaderboard/"

CB1 = "cb1/"
CB2 = "cb2/"
OB = "ob/"
S1 = "s1/"
S2 = "s2/"
LIVE = "live/"

CP = "crossplay"
ST = "steam"
XB = "xbox"
PSN = "psn"

class Contestant:
    def __init__(self, name, rank, change, leagueNumber, league, steamName, xboxName, psnName, cashouts):
        self.name = name
        self.rank = rank
        self.change = change
        self.leagueNumber = leagueNumber
        self.league = league
        self.steamName = steamName
        self.xboxName = xboxName
        self.psnName = psnName
        self.cashouts = cashouts


r = requests.get(url = URL + LIVE + CP)

myjson = r.json()

ourdata = []

csvheader = ['Rank', 'Change', 'Name', 'League Number', 'League', 'Steam Name', 'Xbox Name', 'PSN Name', 'Cashouts']


for x in myjson['data']:
    listing = x['rank'], x['change'], x['name'], x['leagueNumber'],x['league'], x['steamName'], x['xboxName'], x['psnName'], x['cashouts']
    ourdata.append(listing)

# info = json.loads(r.text)

dateOfRecord = datetime.date.today().strftime("%m-%d-%Y")

with open("FinalsRanked_" + dateOfRecord + ".csv", 'w', encoding='UTF8', newline='') as f:
    writer = csv.writer(f)
    writer.writerow(csvheader)
    writer.writerows(ourdata)

print(ourdata)


# contestants = []

# contestant = Contestant('','','','','','','','','')

# for data in info['data']:
#     contestant.name = data['name']
#     contestant.rank = data['rank']
#     contestant.change = data['change']
#     contestant.leagueNumber = data['leagueNumber']
#     contestant.league = data['league']
#     contestant.steamName = data['steamName']
#     contestant.xboxName = data['xboxName']
#     contestant.psnName = data['psnName']
#     contestant.cashouts = data['cashouts']
#     contestants.append(contestant)
#     print(contestant.name)


# print(info['data'])




# examples = {'rank': 9104, 'change': -905, 'leagueNumber': 13, 'league': 'Platinum 4', 'name': 'SonarGeomorph#6540', 'steamName': '', 'xboxName': 'JUKeSpr3e', 'psnName': '', 'cashouts': 0}



