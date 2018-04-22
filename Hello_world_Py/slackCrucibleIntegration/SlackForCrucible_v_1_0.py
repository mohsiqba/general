'''
Created on Nov 26, 2016

@author: mohsiqba
'''
import ast
import requests
import json

class SlackForCrucible(object):
    '''
    classdocs
    '''
    USERNAME='Crucible-BOT'
    
    CHANNEL_TEAM='#crucible_integration'
    
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
        text1=SlackForCrucible.MAIN_TEXT.format(strArr[1])
        text3=SlackForCrucible.ACTIVE_BRANCH.format(strArr[6])
        text4=''
        if isTeam == True:
            text2=SlackForCrucible.TEAM_DATA.format(strArr[2],strArr[3],strArr[4],strArr[5])
            text4=SlackForCrucible.AUTO_CLOSED.format(strArr[7])
            text5=SlackForCrucible.CHANNEL_TEAM
        else:
            text2=SlackForCrucible.INDIVIDUAL_DATA.format(strArr[2],strArr[3],strArr[4],strArr[5])
            text5=strArr[1]
        return ast.literal_eval(SlackForCrucible.PAYLOAD%(SlackForCrucible.USERNAME,text5,text1+text2+text3+text4))
    
    def send_request(self,list):
        payloadList=[]
        for strArr in list:
            payloadList.append(self.frame_payload(strArr,strArr[0]))
        
        for str in payloadList:
            requests.post(SlackForCrucible.SLACK_INCOMING_WEBHOOK_URL, data=json.dumps(str), headers=SlackForCrucible.HEADERS)

slackForCrucible=SlackForCrucible();
list=[]
list.append((False,'@mohsiqba','0','2','2','71','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000'))
list.append((False,'@dhrugoya','122','0','113','3331','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000'))
list.append((True,'CE(#crucible_integration)','156','123 (78.85%)','1666','10.68','2.99 iOS,10.56.DB2 DNA,10.56 Taglib,5.55 Android,5.55 Android PIM App,5.55 Android Docs App,5.55 Android Secure Browser,5.55 Android Secure Editor,5.55 Android Secure Viewer,5.55 Android Kiosk App,CE_2.86.000','MAAS-1120,MAAS-1121,MAAS-1122,MAAS-1123,VIS-259,MEG-9,MAAS-625'))
slackForCrucible.send_request(list)

