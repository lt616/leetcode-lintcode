#!/bin/sh

while true
do
	echo "Select Option:" 
	echo "** Enter 0: exit system" 
	echo "** Enter 1: output ls result"
	echo "** Enter 2: ouput lsblk resut" 
	
	read op

	if [ "$op" == "0" ] 
	then 
		echo "=============================="
		echo "Exit system .."
		break
	elif [ "$op" == "1" ] 
	then
		echo "=============================="
		echo "Output ls result:"
		res=`ls`
		echo "$res"
	elif [ $op == "2" ] 
	then
		echo "=============================="
		echo "Output lsblk result:"
		echo "lsblk result!!" 
	else 
		echo "=============================="
		echo "ERROR: Please enter a valid option." 
	fi

done
