#!/usr/bin/env groovy
import com.jenkinsShared.Docker

def call(){
    return new Docker(this).DockerLogin()
}