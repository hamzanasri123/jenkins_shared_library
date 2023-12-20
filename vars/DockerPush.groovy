#!/usr/bin/env groovy
import com.jenkinsShared.Docker
def call(String imageName){
    return new Docker(this).DockerPush(imageName)
}