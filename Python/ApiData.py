import requests
import datetime
import psycopg2

dateOfRecord = datetime.date.today().strftime("%m-%d-%Y")
conn = psycopg2.connect(dbname="postgres", database="postgres", user="localhost", password="root", port="5506")
cur = conn.cursor()

URL = "https://api.the-finals-leaderboard.com/v1/leaderboard/live/crossplay" # API Endpoint


r = requests.get(url = URL)
dataJson = r.json()


def updateTable():


    sql =       ('''
                INSERT INTO contestant (
                rank, change, name, leagueNumber, league, steamName, xboxName, psnName, cashouts, dateUpdated
                ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
                ''')


    for x in dataJson['data']:
        holder = []
        holder.append(x['rank'])
        holder.append(x['change'])
        holder.append(x['name'])
        holder.append(x['leagueNumber'])
        holder.append(x['league'])
        holder.append(x['steamName'])
        holder.append(x['xboxName'])
        holder.append(x['psnName'])
        holder.append(x['cashouts'])
        cur.execute(sql, holder)

cur.close()
conn.close()
