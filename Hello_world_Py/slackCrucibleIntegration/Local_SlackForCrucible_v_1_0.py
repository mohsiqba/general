'''
Created on Nov 26, 2016

@author: mohsiqba
'''
import ast
import requests
import json

class LocalSlackForCrucible(object):
    '''
    classdocs
    '''
    USERNAME='Crucible-BOT-Local'
    
    CHANNEL_TEAM='#test'
    
    MAIN_TEXT='*Crucible Reviews For * `{0}` \\n'
    
    TEAM_DATA='```# Open Reviews : [{0}] \\n# Overdue Review : [{1}] \\nTotal Overdue Days : [{2}] \\nAvg Overdue Days (per review) : [{3}]\\n```'
    INDIVIDUAL_DATA='```# Open Reviews (To Review) : [{0}] \\n# Open Reviews (To Close) : [{1}] \\n# Overdue Reviews : [{2}] \\n# Days Beyond Due Date : [{3}]\\n```'
    
    ACTIVE_BRANCH='\\n\\nActive branches : `{0}`'
    
    AUTO_CLOSED='\\n\\nReviews automatically closed : `{0}`'
    
    PAYLOAD='{\"username\": \"%s\",\"channel\": \"%s\",\"text\": \"%s\"}'
    
    HEADERS = {'content-type': 'application/json', 'Accept-Charset': 'UTF-8'}

    SLACK_INCOMING_WEBHOOK_URL='https://hooks.slack.com/services/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'
    
    def __init__(self):
        '''
        Constructor
        '''
    
    def frame_payload(self,strArr,isTeam):
        text1=LocalSlackForCrucible.MAIN_TEXT.format(strArr[1])
        text3=LocalSlackForCrucible.ACTIVE_BRANCH.format(strArr[6])
        text4=''
        if isTeam == True:
            text2=LocalSlackForCrucible.TEAM_DATA.format(strArr[2],strArr[3],strArr[4],strArr[5])
            text4=LocalSlackForCrucible.AUTO_CLOSED.format(strArr[7])
            text5=LocalSlackForCrucible.CHANNEL_TEAM
        else:
            text2=LocalSlackForCrucible.INDIVIDUAL_DATA.format(strArr[2],strArr[3],strArr[4],strArr[5])
            text5=strArr[1]
        return ast.literal_eval(LocalSlackForCrucible.PAYLOAD%(LocalSlackForCrucible.USERNAME,text5,text1+text2+text3+text4))
    
    def send_request(self,list):
        payloadList=[]
        for strArr in list:
            payloadList.append(self.frame_payload(strArr,strArr[0]))
        
        for str in payloadList:
            requests.post(LocalSlackForCrucible.SLACK_INCOMING_WEBHOOK_URL, data=json.dumps(str), headers=LocalSlackForCrucible.HEADERS)

slackForCrucible=LocalSlackForCrucible();
list=[]
list.append((False,'@mohsin061','0','2','2','71','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000'))
list.append((False,'@dhruv94','122','0','113','3331','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000'))
list.append((True,'CE(#test)','156','123 (78.85%)','1666','10.68','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000','MAAS-1120,MAAS-1121,MAAS-1122,MAAS-1123,VIS-259,MEG-9,MAAS-625'))
slackForCrucible.send_request(list)

