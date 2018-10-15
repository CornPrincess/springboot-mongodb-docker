import requests
from time import sleep
from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.restful
collection = db.users

url = 'https://hacker-news.firebaseio.com/v0/user/'
users = ['jl', 'andy', 'cc', 'abc', 'oo', 'tb']
for user in users:
    r = requests.get(url + user + '.json')
    print 'processing %s' % r.url
    res = r.json()  # return dict
    collection.insert_one(res)
    print res['id'], 'saved'
    sleep(0.01)