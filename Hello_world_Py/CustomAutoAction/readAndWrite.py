import json 
import os
import sys
import fnmatch


config_filename = os.path.abspath(os.path.join(os.path.dirname(__file__), '', 'mohsin_config.json'))
#config_filename = 'mohsin_config.json'
config_filename1 = os.path.abspath(os.path.join(os.path.dirname(__file__),'..',''))
config_filename2 = os.path.abspath(os.path.join(os.path.dirname(__file__),'..','maas360/mohsin_config.json'))
config_filename3 = os.path.abspath('/home/customactionuser/mohsin_config.json')
print ('sys.argv :'+str(sys.argv))
print ('config filename :'+str(config_filename))
print ('config filename1 :'+str(config_filename1))
print ('config filename2 :'+str(config_filename2))
print ('cwd :'+str(os.getcwd()))
print ('m1:'+os.path.dirname(os.path.realpath(__file__)))
print ('list :'+str(os.listdir(config_filename1)))
#print ('list2 :'+str(os.listdir(config_filename2)))
def write_config(murl, mappid, mappversion, mplatid, makey, musername, mpassword, mbillingid):
    menpassword = mpassword.encode('base64', 'strict')
    framedata = dict(
        maasurl = murl,
        appid = mappid,
        appversion = mappversion, 
        platformid = mplatid,
        accesskey = makey,
        username = musername,
        password = menpassword,
        billingid = mbillingid
        )
    with open(config_filename, 'wb') as configout:
        configout.write(json.dumps(framedata))

def read_config(config_filename):
    try:
        if os.stat(config_filename).st_size > 0:
            print "Processing..."
            with open(config_filename, 'rb') as configin:
                configdata = json.load(configin)
                return configdata
        else:
            print "Empty URL file ..."
            return None
    except Exception as e:
        print "URL file missing ... exiting"+str(e)
        return None





#matches = []
#for root, dirnames, filenames in os.walk(config_filename1):
#    for filename in fnmatch.filter(filenames, '*.*'):
#        matches.append(os.path.join(root, filename))
#for str in matches:
#    print str

#print('matches : '+str(matches))


cdata = read_config(config_filename)
#TO-DO:error in config file
print ('cdata :'+str(cdata))
if cdata is None:
    print('mohsin file empty')
gturl = cdata['maasurl']
gtappid = cdata['appid']
gtappversion = cdata['appversion']
gtplatformid = cdata['platformid']
gtaccesskey = cdata['accesskey']
gtusername = cdata['username']
pss = cdata['password']
gtpss = pss.decode('base64','strict')
gtbillingid = cdata['billingid']
print('cdata: '+str(cdata))
print('gturl: '+gturl)
print('gtappid: '+gtappid)
print('gtappversion:'+gtappversion)
print('gtplatformid:'+gtplatformid)
print('gtaccesskey:'+gtaccesskey)
print('gtusername:'+gtusername)
print('gtpss:'+gtpss)
print('gtbillingid:'+gtbillingid)


cdata = read_config(config_filename2)
#TO-DO:error in config file
gturl = cdata['maasurl']
gtappid = cdata['appid']
gtappversion = cdata['appversion']
gtplatformid = cdata['platformid']
gtaccesskey = cdata['accesskey']
gtusername = cdata['username']
pss = cdata['password']
gtpss = pss.decode('base64','strict')
gtbillingid = cdata['billingid']
print('2.cdata: '+str(cdata))
print('2.gturl: '+gturl)
print('2.gtappid: '+gtappid)
print('2.gtappversion:'+gtappversion)
print('2.gtplatformid:'+gtplatformid)
print('2.gtaccesskey:'+gtaccesskey)
print('2.gtusername:'+gtusername)
print('2.gtpss:'+gtpss)
print('2.gtbillingid:'+gtbillingid)

cdata = read_config(config_filename3)
#TO-DO:error in config file
gturl = cdata['maasurl']
gtappid = cdata['appid']
gtappversion = cdata['appversion']
gtplatformid = cdata['platformid']
gtaccesskey = cdata['accesskey']
gtusername = cdata['username']
pss = cdata['password']
gtpss = pss.decode('base64','strict')
gtbillingid = cdata['billingid']
print('3.cdata: '+str(cdata))
print('3.gturl: '+gturl)
print('3.gtappid: '+gtappid)
print('3.gtappversion:'+gtappversion)
print('3.gtplatformid:'+gtplatformid)
print('3.gtaccesskey:'+gtaccesskey)
print('3.gtusername:'+gtusername)
print('3.gtpss:'+gtpss)
print('3.gtbillingid:'+gtbillingid)
#filename = "/foo/bar/baz.txt"
#if not os.path.exists(os.path.dirname(filename)):
#    try:
#        os.makedirs(os.path.dirname(filename))
#    except OSError as exc: # Guard against race condition
#        if exc.errno != os.errno.EEXIST:
#            raise
#with open(filename, "w") as f:
#    f.write("FOOBAR")