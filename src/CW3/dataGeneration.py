import csv

# 创建文件对象
# f = open('文件名.csv', 'w', encoding = 'utf-8')
f = open('E:/Desktop/FSE/hairline-protection-association/src/CW3/test/Trans_setCategory.csv', 'w', encoding = 'utf-8')

# 基于文件对象构建csv写入对象
csv_writer = csv.writer(f) 


# 根据你的循环体来写入文件内容
for i in range(0, 300, 2):
    csv_writer.writerow([i-150, 1])
    

# 当然也可以按行写入csv文件内容，根据你的特殊需求
csv_writer.writerow([-100, 1])

f.close()