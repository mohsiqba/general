__author__ ="Mohsin Iqbal"
__email__ ="mohsiqba@in.ibm.com"
__status__ ="Prototype v1.0"

import datetime
import json
import time

import argparse
import requests

import xml.etree.ElementTree as ET


class Maasaction(object):
    deviceId = 0
    messageTitle='Alert'
    alertMsg=''
    billingId=0
    password=''
    username=''
    appId=''
    appVersion=0
    platformId=0
    appAccessKey=''
    
    def __init__(self):
        #do nothing
        self.all_data = []
        
        #to-do: get the details dynamically as a command line parameter.
        parser = argparse.ArgumentParser()
        parser.add_argument('--billingId',required=True)
        parser.add_argument('--appId',required=True)
        parser.add_argument('--appVersion',required=True)
        parser.add_argument('--platformId', required=True)
        parser.add_argument('--appAccessKey',required=True)
        parser.add_argument('--username', required=True)
        parser.add_argument('--password',required=True)
        parser.add_argument('--alertMessage', required=True)
        parser.add_argument('--deviceId', required=True)
        args = parser.parse_args()
        
        #intialize variables here
        Maasaction.alertMsg=args.alertMessage
        Maasaction.deviceId=args.deviceId
        Maasaction.billingId=args.billingId
        Maasaction.password=args.password
        Maasaction.username=args.username
        Maasaction.appId=args.appId
        Maasaction.appVersion=args.appVersion
        Maasaction.platformId=args.platformId
        Maasaction.appAccessKey=args.appAccessKey
        
        print ("2.billingId: %s" % Maasaction.billingId )
        print ("2.appId: %s" % Maasaction.appId )
        print ("2.appVersion: %s" % Maasaction.appVersion )
        print ("2.platformId: %s" % Maasaction.platformId )
        print ("2.appAccessKey: %s" % Maasaction.appAccessKey )
        print ("2.username: %s" % Maasaction.username )
        print ("2.password: %s" % Maasaction.password )
        print ("2.alertMessage: %s" % Maasaction.alertMessage )
        
    def frame_xml(self):
        #to-do: get the details dynamically as a command line parameter.
        xml_data = """<authRequest>
        <maaS360AdminAuth>
        <billingID>{0}</billingID>
        <password>{1}</password>
        <userName>{2}</userName>
        <appID>{3}</appID>
        <appVersion>{4}</appVersion>
        <platformID>{5}</platformID>
        <appAccessKey>{6}</appAccessKey>
        </maaS360AdminAuth>
        </authRequest>""".format(Maasaction.billingId, Maasaction.password, Maasaction.username, Maasaction.appId, Maasaction.appVersion, Maasaction.platformId, Maasaction.appAccessKey)
        return xml_data
     
    def authenticate(self):
        #to-do: implement EAFP. Get the billing ID dynamically and updated URI on the fly.
        xml_data = self.frame_xml() 
        headers = {'Content-Type': 'application/xml'}
        resp = requests.post('https://services.fiberlink.com/auth-apis/auth/1.0/authenticate/'+Maasaction.billingId+'/', data=xml_data, headers=headers)
        root = ET.fromstring(resp.text)
        for child in root:
            if child.tag == 'authToken':
                token = child.text
                print token
                return token
            else:
                print 'error'
                return 'error'

    def samplget(self):
        print "To be implemented yet"

    def sampleaction(self):
        mtoken = self.authenticate()
        print 'inside sample action'
        account_url = 'https://b70f4d7d-53fc-4fe9-b9cb-e2f4a44d51f7-bluemix:ad224041f569b6f83711022396a6127f263ffdcc6a9d03c3d1ce75b22cdab4e3@b70f4d7d-53fc-4fe9-b9cb-e2f4a44d51f7-bluemix.cloudant.com'
        db_url = account_url + '/posts'
        dbheaders = {'Content-type': 'application/json'}
        crafttoken = 'MaaS token=' + '"' + mtoken + '"'
        print 'printing craft token'
        print crafttoken
        headers = {'content-type': 'application/x-www-form-urlencoded', 'Authorization': crafttoken}
        url = 'https://services.fiberlink.com/device-apis/devices/1.0/sendMessage/'+Maasaction.billingId
        ts = time.time()
        print ts
        st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')
        print st
        framedata1 = dict(
                maasurl = "before exec sample action 2",    
                mid = Maasaction.deviceId,
                authtoken = mtoken,
                authcraft = crafttoken,
                requrl = url, 
                headers = headers,
                UTCtimestamp = st
        )
        response = requests.post(db_url, data=json.dumps(framedata1), headers=dbheaders)
        params = {'deviceId': Maasaction.deviceId, 'billingID':Maasaction.billingId, 'messageTitle':Maasaction.messageTitle,'message':Maasaction.alertMsg}
        resp = requests.post(url, params = params, headers= headers)
        framedata3 = dict(
                maasurl = "after exec sample action",
                UTCtimestamp = st
        )
        response = requests.post(db_url, data=json.dumps(framedata3), headers=dbheaders)

authobj = Maasaction()
#authobj.sampleaction()
print ("1.billingId: %s" % Maasaction.billingId )
print ("1.appId: %s" % Maasaction.appId )
print ("1.appVersion: %s" % Maasaction.appVersion )
print ("1.platformId: %s" % Maasaction.platformId )
print ("1.appAccessKey: %s" % Maasaction.appAccessKey )
print ("1.username: %s" % Maasaction.username )
print ("1.password: %s" % Maasaction.password )
print ("1.alertMessage: %s" % Maasaction.alertMessage )