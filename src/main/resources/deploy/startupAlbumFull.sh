#!/bin/bash

JAVA_OPTS="${deploy.admin.jvm-args}"

PHOME="${deploy.base}/${project.name}"

pid=`ps -eo pid,args | grep AlbumFullServerBootstrap | grep java | grep -v grep | awk '{print $1}'`

if [ -n "$pid" ]
then
    kill -3 ${pid}
    kill ${pid} && sleep 3
    if [  -n "`ps -eo pid | grep $pid`" ]
    then
        kill -9 ${pid}
    fi
    echo "kill pid: ${pid}"
fi

`/letv/apps/jdk/bin/java -DappPort=1 $JAVA_OPTS -cp $PHOME/conf:$PHOME/lib/* com.letv.mms.transmission.http.AlbumFullServerBootstrap $1 $3 > /dev/null 2>&1 &`