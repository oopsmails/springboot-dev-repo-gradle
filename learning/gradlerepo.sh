#!/bin/bash

base="/home/albert/Documents"
workingdir="$base/dev/gradle/springboot-dev-repo-gradle"
commondir="$workingdir/oopsmails-common"

cmd="gradle clean build publishToMavenLocal"


repodir="/home/albert/.m2/repository/com/oopsmails/springboot/dev/repo"
dirArray=(
	"oopsmails-common-annotation"
	"oopsmails-common-domain"
	"oopsmails-common-filter"
	"oopsmails-common-tool"
	"springboot-dev-repo"
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




echo "=================================="
cd $commondir
# gradle publishToMavenLocal
$cmd
wait

cd $commondir/oopsmails-common-domain
$cmd
wait

cd $commondir/oopsmails-common-annotation
$cmd
wait

cd $commondir/oopsmails-common-filter
$cmd
wait

cd $commondir/oopsmails-common-tool
$cmd
wait

cd $workingdir/spring-boot-java-main/
gradle clean build
# gradle --stacktrace --debug clean build 
wait

cd $commondir

echo "=================================="
