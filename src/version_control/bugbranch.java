package version_control;

public class bugbranch {
    /**
     * bug分支
     *
     * 每个bug都可以通过一个新的临时分支来修复，修复后，合并分支，然后将临时分支删除。
     *
     * 当你接到一个修复一个代号101的bug的任务时，很自然地，你想创建一个分支issue-101来修复它，但是，等等，当前正在dev上进行的工作还没有提交：
     * 并不是你不想提交，而是工作只进行到一半，还没法提交，预计完成还需1天时间。但是，必须在两个小时内修复该bug，怎么办？
     * 幸好，Git还提供了一个stash功能，可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作。
     *
     * 工作区是干净的，刚才的工作现场存到哪去了？用git stash list命令看看
     * 一是用git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除；
     * 另一种方式是用git stash pop，恢复的同时把stash内容也删了：
     *
     *
     * feature分支
     *
     * 做一个试验性的新功能，和bug分支类似
     */
}
