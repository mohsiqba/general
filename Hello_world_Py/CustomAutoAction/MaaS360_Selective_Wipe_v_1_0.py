__author__ ="Mohsin Iqbal"
__email__ ="mohsiqba@in.ibm.com"
__status__ ="Script v1.0"

## Given Scripts accepts arguments in the following order
#billingId[1]
#appId[2]
#appVersion[3]
#platformId[4]
#appAccessKey[5]
#username[6]
#password[7]
#deviceId[8]
##

import ast
import sys
import datetime
import requests
import xml.etree.ElementTree as ET


class  MaaS360_Selective_Wipe_Action(object):
    
    #number of args passed to the script
    num_of_args = 9
    
    #auth service parameters
    maas_auth_url='https://services.fiberlink.com/auth-apis/auth/1.0/authenticate/'
    auth_headers = {'Content-Type': 'application/xml'}
    auth_data = "<authRequest><maaS360AdminAuth><billingID>{0}</billingID><password>{1}</password><userName>{2}</userName><appID>{3}</appID><appVersion>{4}</appVersion><platformID>{5}</platformID><appAccessKey>{6}</appAccessKey></maaS360AdminAuth></authRequest>"
    deviceId = None
    billingId= None
    password= None
    username= None
    appId= None
    appVersion= None
    platformId= None
    appAccessKey= None
    
    #action specific parameters
    maas_service_url='https://services.fiberlink.com/device-apis/devices/1.0/'
    maas_service_action='selectiveWipeDevice'
    action_service_headers ="{ 'content-type' : 'application/x-www-form-urlencoded' , 'Authorization' : '%s' }"
    action_service_params = "{ 'deviceId' : '%s' , 'billingID' : '%s' }"
    
    def __init__(self):
        #do nothing
        self.all_data = []
        
        #prepare logging framework here
        
        #test if there are num_of_args params passed to it else log and exit.
        print ('sys.argv :'+str(sys.argv))
        arglen=len(sys.argv)
        if arglen != MaaS360_Selective_Wipe_Action.num_of_args :
            print ('insufficient number of arguments. expected ['+str(MaaS360_Selective_Wipe_Action.num_of_args-1)+'] got ['+str(arglen-1)+']')
            sys.exit(0)
        
        #intialize variables here
        MaaS360_Selective_Wipe_Action.billingId=sys.argv[1]
        MaaS360_Selective_Wipe_Action.appId=sys.argv[2]
        MaaS360_Selective_Wipe_Action.appVersion=sys.argv[3]
        MaaS360_Selective_Wipe_Action.platformId=sys.argv[4]
        MaaS360_Selective_Wipe_Action.appAccessKey=sys.argv[5]
        MaaS360_Selective_Wipe_Action.username=sys.argv[6]
        MaaS360_Selective_Wipe_Action.password=sys.argv[7]
        MaaS360_Selective_Wipe_Action.deviceId=sys.argv[8]
               
        if MaaS360_Selective_Wipe_Action.billingId is None or MaaS360_Selective_Wipe_Action.billingId == 'null':
            print ('billingId is null')
            sys.exit(1)
        if MaaS360_Selective_Wipe_Action.appId is None or MaaS360_Selective_Wipe_Action.appId == 'null':
            print ('appId is null')
            sys.exit(2)
        if MaaS360_Selective_Wipe_Action.appVersion is None or MaaS360_Selective_Wipe_Action.appVersion == 'null':
            print ('appVersion is null')
            sys.exit(3)
        if MaaS360_Selective_Wipe_Action.platformId is None or MaaS360_Selective_Wipe_Action.platformId == 'null':
            print ('platformId is null')
            sys.exit(4)
        if MaaS360_Selective_Wipe_Action.appAccessKey is None or MaaS360_Selective_Wipe_Action.appAccessKey == 'null':
            print ('appAccessKey is null')
            sys.exit(5)
        if MaaS360_Selective_Wipe_Action.username is None or MaaS360_Selective_Wipe_Action.username == 'null':
            print ('username is null')
            sys.exit(6)
        if MaaS360_Selective_Wipe_Action.password is None or MaaS360_Selective_Wipe_Action.password == 'null':
            print ('password is null')
            sys.exit(7)
        if MaaS360_Selective_Wipe_Action.deviceId is None or MaaS360_Selective_Wipe_Action.deviceId == 'null':
            print ('deviceId is null')
            sys.exit(9)
            
    #return authentication arguments in the form of xml        
    def frame_auth_xml(self):
        return MaaS360_Selective_Wipe_Action.auth_data.format(MaaS360_Selective_Wipe_Action.billingId, 
                                                            MaaS360_Selective_Wipe_Action.password, 
                                                            MaaS360_Selective_Wipe_Action.username, 
                                                            MaaS360_Selective_Wipe_Action.appId, 
                                                            MaaS360_Selective_Wipe_Action.appVersion, 
                                                            MaaS360_Selective_Wipe_Action.platformId, 
                                                            MaaS360_Selective_Wipe_Action.appAccessKey)
     
    #return action specific url 
    def frame_action_url(self):
        return MaaS360_Selective_Wipe_Action.maas_service_url+MaaS360_Selective_Wipe_Action.maas_service_action+'/'+MaaS360_Selective_Wipe_Action.billingId+'/'
    
    #return action specific headers 
    def frame_action_header(self,auth_token):
        return ast.literal_eval(MaaS360_Selective_Wipe_Action.action_service_headers%(auth_token))
    
    #return action specific params 
    def frame_action_params(self):
        return ast.literal_eval(MaaS360_Selective_Wipe_Action.action_service_params%(MaaS360_Selective_Wipe_Action.deviceId,
                                                                                   MaaS360_Selective_Wipe_Action.billingId))
    
    #perform authentication and return following
    #success -> auth token
    #failure -> failure response
    def authenticate(self):
        token='error : '
        xml_data = self.frame_auth_xml()   
        auth_resp = requests.post(MaaS360_Selective_Wipe_Action.maas_auth_url+MaaS360_Selective_Wipe_Action.billingId+'/', 
                                  data=xml_data, 
                                  headers=MaaS360_Selective_Wipe_Action.auth_headers)
        root = ET.fromstring(auth_resp.text)
        for child in root:
            if child.tag == 'authToken':
                return child.text
            
        token+=auth_resp.text
        return token
    
    #perform send message action
    def selective_wipe_action(self):
        st = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        mtoken = self.authenticate()
        if 'error' in mtoken :
            print ('authentication unsuccessful with '+mtoken)
            sys.exit(10)
        authorization_token = 'MaaS token=' + '"' + mtoken + '"'    
        resp=requests.post(self.frame_action_url(),params = self.frame_action_params(),headers = self.frame_action_header(authorization_token))
        print ('response: '+resp.text)
        
authobj = MaaS360_Selective_Wipe_Action()
authobj.selective_wipe_action()
