#发版默认command
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy194FullAlbum.sh &&
sleep 10 &&
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy184FullVideo.sh &&
sleep 10 &&
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy194Album.sh &&
sleep 10 &&
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy194Video.sh&&
sleep 10 &&
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy184Album.sh&&
sleep 10 &&
sh -ex $WORKSPACE/mms-search-transmission/target/deploy/deploy184Video.sh

#统计请求状态命令
cat geturl.20170807.log  | grep "/mms/inner" |awk '{if($9!=200) print substr($4,0,18),$9}'| uniq -c;

#统计ID总数命令
ls |grep -v gz|xargs awk '{print $1}' |sort -u|wc -l