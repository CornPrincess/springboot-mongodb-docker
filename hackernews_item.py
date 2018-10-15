import requests
from time import sleep
from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.restful
collection = db.items

url = 'https://hacker-news.firebaseio.com/v0/item/'
for item in range(1, 10):
    r = requests.get(url + bytes(item) + '.json')
    print 'processing %s' % r.url
    res = r.json()  # return dict
    collection.insert_one(res)
    print res['type'], 'saved'
    sleep(0.01)