package version_control;

public class git {
    /**
     * git概念
     * 1. head
     * 2. 工作区：电脑里能看到的目录
     * 3. 暂存区：工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。
     Git的版本库里存了很多东西，其中最重要的就是称为stage（或者叫index）的暂存区，还有Git为我们自动创建的第一个分支master，以及指向master的一个指针叫HEAD。
     前面讲了我们把文件往Git版本库里添加的时候，是分两步执行的：
     第一步是用git add把文件添加进去，实际上就是把文件修改添加到暂存区；
     第二步是用git commit提交更改，实际上就是把暂存区的所有内容提交到当前分支。
     * 4. Fast forward模式：这种模式下，删除分支后，会丢掉分支信息。
     */
    /**
     * git 分布式版本管理
     * 基本操作
     * 初始化
     * 1. git init
     * 2. git add
     * 3. git commit -m
     *
     * 查看修改
     * git status
     * git diff HEAD -- readme.txt命令可以查看工作区和版本库里面最新版本的区别
     *
     * 日志
     * git log
     * git log --graph 查看分支合并图
     * git reflog：回退以后又想再次回到之前的版本，git reflog 可以查看所有分支的所有操作记录（包括commit和reset的操作），包括已经被删除的commit记录，git log则不能察看已经删除了的commit记录
     *
     *
     * 远程库：
     * git push命令，实际上是把当前分支master推送到远程。
     *
     * git remote add origin git@server-name:path/repo-name.git 远程库关联
     * 关联后，使用命令git push -u origin master第一次推送master分支的所有内容；(加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来)
     * 此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送最新修改；
     *
     */
}
