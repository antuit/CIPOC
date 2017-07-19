#!/bin/sh
set +e
DATABASE=postgrescommon
USERNAME=postgrescommon
HOsTNAME=postgrescommon
export PGPASSWORD=postgrescommon

PCOUNT=`psql -U postgrescommon -p 5432 -h 52.229.20.59  << EOF
select count(*) 
from company
EOF`

PCOUNT1=${PCOUNT:21:2}
PCOUNT2=$(echo $PCOUNT1 | tr -d ' ')
echo ${PCOUNT2}

db_name=cipoc
table_name=real_estate_trans
HCOUNT1=`hive -S -e "select count(*) from cipoc.sample;"`
HCOUNT2=$(echo $HCOUNT1 | tr -d ' ')
echo $HCOUNT2


if [$PCOUNT2=$HCOUNT2]
then
	echo "Source and Destination counts match, Testcase : PASSED"
	exit 0
else
	echo "Source count $PCOUNT2 and Destination count $HCOUNT2, Testcase : FAILED"
	exit 1
fi
