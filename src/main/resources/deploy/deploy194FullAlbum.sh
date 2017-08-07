#!/bin/bash
name="${project.name}"
deploy="${deploy.base}"
webapp="${deploy}/${project.name}"
servers=(${deploy.crontab.server2})
SCRIPT_HOME="${deploy}/${project.name}/deploy"
site="${deploy.site}"

serverCount=${#servers[@]}
serial_no=`date +%s`
dateFormat=`date +%Y-%m-%d`
scount=0
while [ $scount -lt $serverCount ]
do
	echo -e "\n\n\n\n"
    server=${servers[$scount]}
    echo "deploy $name on $server"
    host=`echo $server`

    if [ ! -s $deploy/$name-$serial_no.tar ] ; then
        ssh root@$host "mkdir -p $webapp"

        scp $WORKSPACE/mms-search-transmission/target/$name.tar.gz root@$host:$deploy
        ssh root@$host "rm -rf $webapp/*"
		ssh root@$host "cd ${deploy} && tar -zxv -f $deploy/$name.tar.gz"
		ssh root@$host "mv $webapp/conf/deploy $webapp/"
        ssh root@$host "cp $deploy/$name.tar.gz $deploy/$name-$serial_no.tar.gz &&  mv $deploy/$name-$serial_no.tar.gz $deploy/bak/"
        ssh root@$host "chmod 777 $SCRIPT_HOME/*"
    fi

    ssh root@$host "bash -ex $SCRIPT_HOME/runAlbumFull.sh $server $1 $site"
    scount=$((scount+1))
done
echo "all done."
