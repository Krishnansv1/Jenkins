job('nodejs Example'){
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
        shell("npm install")
    }
}