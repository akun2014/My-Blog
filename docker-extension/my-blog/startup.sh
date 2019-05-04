#!/bin/bash
set -e

sleep 25

echo '开始启动项目.....'
nohup java -jar /app.jar --spring.profiles.active=default -Djasypt.encryptor.password=${JASYPT_PASSWORD}