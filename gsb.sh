#!/bin/bash

export AWS_KEY_FILE=aws-ec2-ubuntu.pem
export AWS_EC2_PUBLIC_DNS=ec2-3-87-8-194.compute-1.amazonaws.com
export AWS_EC2_INST=ubuntu@$AWS_EC2_PUBLIC_DNS

export BACKEND_JAR=springboot-backend/target/springboot-backend-0.0.1-SNAPSHOT.jar
export FRONT_END_DIR=angular-frontend/dist/angular-frontend/

if [[ $# -eq 0 ]]; then
	echo 'No parameter supplied'
	exit 1
fi

chmod 400 $AWS_KEY_FILE

if [[ $1 == "-ssh" ]];then
	ssh -i $AWS_KEY_FILE $AWS_EC2_INST
elif [[ $1 == "-scp" && $2 == "-b" ]];then
	scp -i $AWS_KEY_FILE $BACKEND_JAR $AWS_EC2_INST:~/
elif [[ $1 == "-scp" && $2 == "-f" ]];then
	scp -r -i $AWS_KEY_FILE $FRONT_END_DIR $AWS_EC2_INST:~/
else
	echo 'Invalid parameters'
	exit 1
fi
