#!/usr/bin/env groovy
package com.jenkinsShared


class Docker {
    def script

    Docker(script){
        this.script = script
    }

    def BuildDockerImage(String imageName) {
        script.echo 'building jar file '
        script.sh "docker build -t $imageName ."
    }

    def DockerLogin(){
        script.echo 'Login to  Docker .... '
        script.withCredentials([usernamePassword(credentialsId : 'docker-hub-repo',passwordVariable:'PWD',usernameVariable:'USER')]){
            script.sh "echo $script.PWD | docker login -u $script.USER --password-stdin"
        }
    }

    def DockerPush(String imageName){
        script.echo 'Push to docker  '
        script.sh "docker push $imageName"
    }
}
