package version_control;

public class cooperation {
    /**
     *

     查看远程库信息，使用git remote -v；

     本地新建的分支如果不推送到远程，对其他人就是不可见的；

     从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；

     在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；

     建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；

     从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。

     git rebase: 相比git merge，git rebase更加整洁
     ：这些命令会把你的"mywork"分支里的每个提交(commit)取消掉，并且把它们临时 保存为补丁(patch)(这些补丁放到".git/rebase"目录中),
     然后把"mywork"分支更新 到最新的"origin"分支，最后把保存的这些补丁应用到"mywork"分支上。

     * 简而言之就是你的commit在别人的commit之后
     */
}
