1.首页根据ViewPager + Fragment + ViewPagerIndicator来搭建界面的主体,并根据各个界面的ListView展现形
式抽取成基类. 提高复用.
2. 将Fragment数据层,视图层.分割,抽取.
3. 视图层.以holder形式展示, 再次分割视图层, 每一个View即为holder.
