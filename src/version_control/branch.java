package version_control;

public class branch {
    /**
     * 分支相关
     */

    /**
     * 分支：
     *
     * HEAD严格来说不是指向提交，而是指向master，master才是指向提交的，所以，HEAD指向的就是当前分支。
     * Git创建一个分支很快，因为除了增加一个dev指针，改改HEAD的指向，工作区的文件都没有任何变化！
     *
     * Git鼓励大量使用分支：
     * 查看分支：git branch
     * 创建分支：git branch <name>
     * 切换分支：git checkout <name>（区别撤回命令）
     * 创建+切换分支：git checkout -b <name>
     * 合并某分支到当前分支：git merge <name>
     * 删除分支：git branch -d <name>
     *
     * 冲突解决
     * Git用<<<<<<<，=======，>>>>>>>标记出不同分支的内容，我们修改后保存：
     *
     * 准备合并dev分支，请注意--no-ff参数，表示禁用Fast forward：
     *
     * 分支策略
     *
     * 首先，master分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；
     * 那在哪干活呢？干活都在dev分支上，也就是说，dev分支是不稳定的，到某个时候，比如1.0版本发布时，再把dev分支合并到master上，在master分支发布1.0版本；
     * 你和你的小伙伴们每个人都在dev分支上干活，每个人都有自己的分支，时不时地往dev分支上合并就可以了。
     *
     */
}
