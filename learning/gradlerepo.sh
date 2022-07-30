#!/bin/bash

base="/home/albert/Documents"
workingdir="$base/dev/gradle/springboot-dev-repo-gradle"
commondir="$workingdir/oopsmails-common"

repodir="/home/albert/.m2/repository/com/oopsmails/springboot/dev/repo"
commonDirArray=(
	# this oopsmails-common-domain first!
	"oopsmails-common-domain"
	"oopsmails-common-annotation"
	"oopsmails-common-filter"
	"oopsmails-common-tool"
)

publishDirArray=(
	"spring-boot-java-main"
)

buildDirArray=(
	"spring-boot-mock-backend"
	"spring-boot-mongodb-security-angular-backend"
)


for d in "${commonDirArray[@]}"
do
	# echo "$d"
	# cd "$repodir/$d"
	# pwd
	echo "$repodir/$d"
	rm -rf "$repodir/$d"
done

for d in "${publishDirArray[@]}"
do
	echo "$repodir/$d"
	rm -rf "$repodir/$d"
done

cmdPublish="gradle clean build publishToMavenLocal"
cmdBuild="gradle clean build"
# cmd="gradle clean build publishToMavenLocal --info"

for d in "${commonDirArray[@]}"
do
	echo "=================================="
	cd $commondir/$d
	pwd
	$cmdPublish
	wait
done

for d in "${publishDirArray[@]}"
do
	echo "=================================="
	cd $workingdir/$d
	pwd
	$cmdPublish
	wait
done

for d in "${buildDirArray[@]}"
do
	echo "=================================="
	cd $workingdir/$d
	pwd
	$cmdBuild
	wait
done

cd $workingdir

echo "=================================="
