DATABASE=postgrescommon
USERNAME=postgrescommon
HOsTNAME=postgrescommon
export PGPASSWORD=postgrescommon

PCOUNT=`psql -U postgrescommon -p 5432 -h 52.229.20.59  << EOF
select count(*) 
from company
EOF`

echo $PCOUNT
