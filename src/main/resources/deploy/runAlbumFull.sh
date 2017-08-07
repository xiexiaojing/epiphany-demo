#!/bin/bash

HOST=$1
if [[ -z "$1" ]]; then
	HOST=`/sbin/ifconfig -a|grep inet|grep -v 127.0.0.1|grep -v inet6|awk '{print $2}'|tr -d "addr:"`
fi
INDEX=0

SCRIPT_HOME=$(dirname $(readlink -f $0))
for i in $(seq 0 $INDEX)
do
    bash -ex $SCRIPT_HOME/startupAlbumFull.sh $2 $HOST $3
done