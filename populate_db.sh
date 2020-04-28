#!/usr/bin/env bash

curl -X POST \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"name": "Short Sword", "type": "sword", "description": "A standard short sword.", "attackPower": 8, "attackType": "slashing", "specialAbility": "none", "weight": 15.2}' \
http://localhost:8090/weapons

curl -X POST \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"name": "Long Sword", "type": "sword", "description": "A standard long sword.", "attackPower": 12, "attackType": "slashing", "specialAbility": "none", "weight": 23.5}' \
http://localhost:8090/weapons

curl -X POST \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"name": "Battle Axe", "type": "axe", "description": "A standard battle axe.", "attackPower": 15, "attackType": "slashing", "specialAbility": "none", "weight": 35}' \
http://localhost:8090/weapons

curl -X POST \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"name": "Morning Star", "type": "mace", "description": "A standard morning star.", "attackPower": 11, "attackType": "blunt", "specialAbility": "none", "weight": 20}' \
http://localhost:8090/weapons
