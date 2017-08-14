#!/bin/bash
# 在开始操作之前移除所有的配置
# 多个 传入多个地址  判断 并且删除

for i in $@;do
if [ -d "$i" ] || [ -f "$i" ] ; then
  echo "清理之前的缓存[$i]"
  rm -rf $i;
fi;
done
