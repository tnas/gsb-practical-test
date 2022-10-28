#!/bin/bash

sudo rm -f /var/www/gsb/*
sudo cp angular-frontend/* /var/www/gsb
sudo systemctl restart nginx
