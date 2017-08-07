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