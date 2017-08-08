#!/bin/bash

JAVA_OPTS="-server -Xms30g -Xmx30g -Xmn17g -Xverify:none \
-Xss16m -XX:+UseParallelGC -XX:MaxTenuringThreshold=6  -XX:+UseParallelOldGC -XX:+UseAdaptiveSizePolicy -XX:MaxGCPauseMillis=100 -XX:ParallelGCThreads=24 \
-XX:+UseTLAB -XX:TLABSize=1g -XX:+ResizeTLAB -XX:+PrintTLAB -verbose -XX:+PrintGCApplicationStoppedTime \
-XX:+PrintGCApplicationStoppedTime -XX:+PrintFlagsFinal -Xloggc:/letv/logs/mms/gcablumfull.log \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/letv/logs/mms/increment-dump.log"

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

`/letv/apps/jdk/bin/java -DappPort=3 $JAVA_OPTS -cp $PHOME/conf:$PHOME/lib/* com.letv.mms.transmission.http.AlbumFullServerBootstrap $1 $3 > /dev/null 2>&1 &`