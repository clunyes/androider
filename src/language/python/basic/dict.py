dict = {'张正鹤':90,'张忠武':85,'王海飞':85}
# print('张正鹤得了',dict['张正鹤'],'分')
# print('张正鹤得了',dict.get('张正鹤'),'分')
# print('丁立' in dict)
# print('丁立',dict.get('丁立',-1),'分')
print(dict.pop('王海飞'))
dict['丁立']=100
print('丁立得了',dict['丁立'],'分')