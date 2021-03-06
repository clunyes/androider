package design_pattern.structural_design_pattern.composite;
/**
 * 组合模式，就是在一个对象中包含其他对象，这些被包含的对象可能是终点对象（不再包含别的对象），
 * 也有可能是非终点对象（其内部还包含其他对象，或叫组对象），我们将对象称为节点，即一个根节点包含许多子节点，
 * 这些子节点有的不再包含子节点，而有的仍然包含子节点，以此类推。很明显，这是树形结构，终结点叫叶子节点，
 * 非终节点（组节点）叫树枝节点，第一个节点叫根节点。同时也类似于文件目录的结构形式：文件可称之为终节点，目录可称之为非终节点（组节点）。
 */
/**
 * 在android中，viewgroup和view就是标准的组合模式
 */