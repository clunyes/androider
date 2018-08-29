package version_control;

public class withdraw {
    /**
     * 撤回
     *
     * git checkout -- readme.txt意思就是，把readme.txt文件在工作区的修改全部撤销，这里有两种情况：（--很重要，否则变成切换分支）
     一种是readme.txt自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；
     一种是readme.txt已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。
     总之，就是让这个文件回到最近一次git commit或git add时的状态。

     * git reset HEAD <file>可以把暂存区的修改撤销掉（unstage），重新放回工作区：
     */
}
