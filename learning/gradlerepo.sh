#!/bin/bash

base="/home/albert/Documents"
workingdir="$base/dev/gradle/springboot-dev-repo-gradle"
commondir="$workingdir/oopsmails-common"

repodir="/home/albert/.m2/repository/com/oopsmails/springboot/dev/repo"
dirArray=(
	# this oopsmails-common-domain first!
	"oopsmails-common-domain"
	"oopsmails-common-annotation"
	"oopsmails-common-filter"
	"oopsmails-common-tool"
	"spring-boot-java-main"
)


for d in "${dirArray[@]}"
do
	# echo "$d"
	# cd "$repodir/$d"
	# pwd
	echo "$repodir/$d"
	rm -rf "$repodir/$d"
done

cmd="gradle clean build publishToMavenLocal"
# cmd="gradle clean build publishToMavenLocal --info"


for d in "${dirArray[@]}"
do
	echo "=================================="
	cd $commondir/$d
	pwd
	$cmd
	wait
done

cd $workingdir

echo "=================================="
