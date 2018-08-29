package version_control;

public class tag {
    /**
     * 发布一个版本时，我们通常先在版本库中打一个标签（tag），这样，就唯一确定了打标签时刻的版本。将来无论什么时候，取某个标签的版本，就是把那个打标签的时刻的历史版本取出来。
     * 所以，标签也是版本库的一个快照。

     * Git的标签虽然是版本库的快照，但其实它就是指向某个commit的指针（跟分支很像对不对？但是分支可以移动，标签不能移动），所以，创建和删除标签都是瞬间完成的。
     *
     * 首先，切换到需要打标签的分支上：
     * git tag <name>就可以打一个新标签：
     * git tag查看所有标签
     *
     * 命令git push origin <tagname>可以推送一个本地标签；
     * 命令git push origin --tags可以推送全部未推送过的本地标签；
     * 命令git tag -d <tagname>可以删除一个本地标签；
     * 命令git push origin :refs/tags/<tagname>可以删除一个远程标签。
     */
}
