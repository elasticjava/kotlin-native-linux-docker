#!/bin/bash
# idea inspired by Marc Reichelt - https://dev.to/mreichelt/christmas-hacking-squeezing-kotlin-native-into-docker-6ao
mkdir -p ./shared
find build/bin/linuxX64 -type f | xargs -I '[]' ldd '[]' | grep -Po "/lib[^ ]*" | xargs -I '{}' cp --parents -v '{}' ./shared/$(dirname '.{}')
