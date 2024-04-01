import requests
import csv
import datetime

dateOfRecord = datetime.date.today().strftime("%m-%d-%Y")

URL = "https://api.the-finals-leaderboard.com/v1/leaderboard/" # API Endpoint

# 1st Portion Filter ( required )

CB1 = "cb1/"
CB2 = "cb2/"
OB = "ob/"
S1 = "s1/"
S2 = "s2/"
LIVE = "live/"

# 2nd Portion Filter ( required )

CP = "crossplay"
ST = "steam"
XB = "xbox"
PSN = "psn"

# API Get request

r = requests.get(url = URL + LIVE + CP)
dataJson = r.json()

ranks = []

csvtitle = ['The Finals Leaderboard', 'Date:', dateOfRecord]
csvheader = ['Rank', 'Change', 'Name', 'League Number', 'League', 'Steam Name', 'Xbox Name', 'PSN Name', 'Cashouts']

for x in dataJson['data']:
    listing = x['rank'], x['change'], x['name'], x['leagueNumber'],x['league'], x['steamName'], x['xboxName'], x['psnName'], x['cashouts']
    ranks.append(listing)

with open("The_Finals_Ranked_" + dateOfRecord + ".csv", 'w', encoding='UTF8', newline='') as f:
    writer = csv.writer(f)
    writer.writerow(csvheader)
    writer.writerows(ranks)
