job('nodejs  docker Example'){
    scm{
        git('git://github.com/krishnansv1/jenkinsNode.git'){node->
            node /gitConfigName('DSL User')
            node / gitConfigEmail('krishnansv@yahoo.com')
        }
    }
    triggers{
        scm('H/5 * * * *')
    }
    wrappers{
        nodejs('nodejs')

    }
    steps{
        dockerBuildAndPublish {
            repositoryName('krishnansv/dockerjenkins-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
            }
    }
}