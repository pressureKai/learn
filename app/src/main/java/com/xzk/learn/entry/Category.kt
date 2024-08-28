package com.xzk.learn.entry

// vararg 可变参数
class Category(val name: String, vararg item: Item) {
    // 可变参数转换成List
    val listOfItems: List<Item> = item.toList()
}
// summary 概要
val dummyCategories = mutableListOf(
    Category(
        "博客主页",
        Item("博客主页","https://pressurekai.github.io/","博客","博客主页", arrayListOf()),
    ),
    Category(
        "C++",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
    ),
    Category(
        "Compose",
        Item("点击事件处理","https://blog.csdn.net/pepsimaxin/article/details/135742686","点击事件处理","点击事件处理",
            arrayListOf()
        ),
        Item("底部导航栏","https://www.cnblogs.com/stars-one/p/17154864.html","底部导航栏","底部导航栏", arrayListOf()),
        Item("书籍翻页","https://github.com/FantasticPornTaiQiang/PTQFlipper","书籍翻页","书籍翻页", arrayListOf()),
        Item("占位空间控件","https://blog.csdn.net/sange77/article/details/126426668","占位空间控件","占位空间控件", arrayListOf()),
        Item("compose项目学习","https://github.com/FunnySaltyFish/JetpackComposeStudy","compose项目学习","compose项目学习", arrayListOf()),
        Item("Hilt用法","https://www.jianshu.com/p/252c407bed19","Hilt用法","Hilt用法", arrayListOf()),
        Item("Compose博客园入门教程","https://www.cnblogs.com/sixrain/p/18036442","Compose博客园入门教程","Compose博客园入门教程", arrayListOf()),

        ),
    Category(
        "Android Framework",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
        Item("写给应用开发的 Android Framework 教程","http://ahaoframework.tech/","阿豪讲Framework","阿豪讲Framework", arrayListOf()),
    ),
    /**
     * 知识点
     *  1. android_media_MediaPlayer.cpp 类中的 android_media_MediaPlayer_native_init() 函数 通过JNI调用Java层的MediaPlayer.java拿到mNativeContext对象指针，
     *  调用mNativeContext类的静态方法postEventFromNative,把Native 事件回调到Java层
     *     jclass clazz;
     *     clazz = env->FindClass("android/media/MediaPlayer");
     *     if(clazz == NULL){
     *       return;
     *     }
     *     //在域中的context 赋值一个java类中的一个成员变量对象的指针
     *     fields.context = env->GetFieldID(clazz,"mNativeContext","J");
     *     if(field.context == NULL){
     *       return;
     *     }
     *     //获取一个MediaPlayer中的静态方法。
     *     // 参数 1. clazz  字节码对象
     *     //     2. postEventFromNative 函数名
     *     //     3. "(Ljava/lang/Object;IIILjava/lang/Object;)V" 暂不了解
     *     fields.post_event = env->GetStaticMethodID(clazz,"postEventFromNative","(Ljava/lang/Object;IIILjava/lang/Object;)V");
     *
     *
     *
     *
     *
     *
     *    手动分界线 -------   Binder ----------
     *    1.linux 在线课程 https://www.icourse163.org/learn/UESTC-1003040002?tid=1455108444#/learn/content?type=detail&id=1228729494
     *      1). ls -a 查看所有文件
     *      2). ls -l 显示文件详细信息
     *      3). ls -d 查看目录属性
     *      4). pwd 查看当前工作路径
     *      5). cd change directory
     *      6). mkdir make directory 创建一个新目录
     *      7). rmdir remove directory  删除一个空目录
     *      8). cat concatenate and display files 查看文件内容
     *           1. cat -E 在每一行的末尾添加$
     *           2. cat -n 在每一行的末尾添加行号
     *           cat m1 显示m1文件内容
     *           cat m1 m2 同时显示m1和m2文件内容
     *
     *      9). more 分页显示文件内容
     *
     *           more /etc/services
     *           空格 或 f 显示下一页
     *           Enter    显示下一行
     *           q 或 Q    退出
     *
     *           less 与 more 命令类似，可以利用上下键卷动文件
     *
     *      10). head -n 显示文件前几行的内容，默认10行
     *      11). tail -n 显示文件后几行的内容，默认10行
     *      12). cp 将文件从一处复制到另一处
     *           cp 1.txt -p 2.txt 连同文件属性一起复制，常用于备份
     *           cp 1.text -i 2.txt 若目标文件已存在，会先询问覆盖操作的进行
     *           cp dir1 -r dir2  文件递归复制
     *           cp 1.txt -u 2.txt 目标文件与源文件有差异的时候才会复制
     *      13). rm remove
     *           rm -i 删除前询问用户是否删除
     *           rm -f force,忽略不存在的文件
     *           rm -r 递归删除目录
     *           rm -f *.txt 删除后缀名为txt的文件
     *      14). find 寻找文件或目录
     *           find -name 1  找出文件名为1的文件
     *           find -size +1024 找出比1024大的文件
     *           find -size -1024 找出比1024小的文件
     *           find -perm 0755 找出0755权限的文件
     *           find -type f   一般文件
     *                      b,c 设备文件
     *                      d   目录
     *                      i   连接文件
     *                      s   socket套接字文件
     *                      p   pipe 管道文件
     *      15). grep Globally search a Regular Expression and print
     *                在文件中搜索匹配的字符并输出
     *                -a : 将binary(二进制)文件以text文件的方式查找数据
     *                -c : 记录查找字符串的个数
     *                -i : 忽略大小写
     *                -v : 反向查找不包含指定的字符串的行
     *       16).tar tape archive
     *               tar -c 新建打包文件
     *               tar -t 查看打包文件的内容包含有哪些文件名
     *               tar -x 解打包或解压缩的功能，可以搭配-C(大写)指定解压目录，ps: -c,-t,-x不能同时出现在同一条命令中
     *               tar -j 通过bzip2的支持进行压缩、解压缩
     *               tar -z 通过gzip的支持进行压缩、解压缩
     *               tar -v 在解压缩过程中，将正在处理的文件名显示出来
     *               tar -f filename : filename 为要处理的文件
     *               tar -C dir: 指定压缩与解压缩的路径
     *
     *               示例:
     *               tar -cvf test.tar *
     *               将当前目录所有文件打包成test.tar
     *
     *               tar -czvf test.tar.gz *
     *               将当前目录所有文件打包成test.tar,再用gzip压缩
     *
     *               tar -tf test.tar
     *               查看test.tar当前压缩包中的文件
     *
     *               tar -xvf test.tar
     *               解压缩test.tar压缩包
     *
     *               tar -xzvf test.tar
     *               将test.tar解压缩并使用gzip压缩
     *
     *        17) ps 用来显示系统瞬间进程信息
     *               ps -l 长格式输出
     *               ps -u 按用户名和启动时间的顺序来显示进程
     *               ps -j 用任务格式来显示进程
     *               ps -f 用树的形式来显示进程
     *               ps -a 显示所有用户的所有进程
     *               ps -x 显示无控制终端的进程
     *               ps -r 显示运行中的进程
     *
     *               ps -aux
     *               查看系统和每位用户的全部进程
     *
     *               ps -aux|grep ppp
     *               查找用户ppp进程
     *
     *          18) top 持续更新进程信息
     *              top -b 以批量模式运行，但不能接受命令行输入
     *              top -c 显示命令行,而不仅仅显示命令名
     *              top -d N 每次刷新信息的时间间隔
     *              top -i 显示空闲进程和僵尸进程
     *              top -n Number 显示更新的次数，然后退出
     *              top -p Pid 监视进程ID
     *              top -q 不经任何延迟更新信息
     *              top -s 安全模式运行
     *              top -S 输出每个进程的总CPU时间
     *
     *          19) kill -signal PID
     *              kill -SIGHUP PID 启动被终止的进程
     *              kill -SIGINT PID 相当于ctrl+c ,中断一个程序的运行
     *              kill -SIGKILL 强制一个进程的进行
     *              kill -SIGTERM 以正常结束进程来终止进程
     *              kill -SIGSTOP 相当于ctrl+z,暂停一个进程
     *
     *          20) killall 使用进程命令杀死进程，使用此命令可以杀死同一组同名进程
     *              killall progressName
     *              killall -e 对长名称进行精准匹配
     *              killall -i 忽略大小写不同
     *              killall -p 杀死进程所属的进程组
     *              killall -i 交互式，杀死进程时询问用户
     *              killall -l 打印所有已知信号列表
     *              killall -q 如果没有进程被杀死，不输出任何信息
     *          21) nice 命令允许程序在原有的优先级上增大或减小优先级
     *              nice -n -5 myprogram&
     *              优先级-5运行myprogram
     *          22) renice 改变一个正在运行的进程的nice值
     *              renice -5 777
     *          23) jobs 查看被挂起的进程
     *          24) linux 系统分为3类 超级用户、系统用户、普通用户
     *          25) 用户ID uid 用户组id gid
     *          26) 用户账号信息文件 /etc/password
     *              用户口令信息文件 /etc/shadow
     *              用户组账号信息文件 /etc/group
     *              用户组口令信息文件 /etc/gshadow
     *          27) useradd 添加用户
     *              -d 指定用户登入时的主目录
     *              -e 账号的终止日期
     *              -g 指定账户所属的用户组
     *              -G 指定账户所属的附加组
     *              -s 指定账户登录后所属的shell
     *              -u 指定用户的ID号
     *          28) password 设置和修改用户口令及属性
     *              -d 删除用户指令
     *              -l 暂时锁定指定用户的指令
     *              -u 解除指定用户的锁定
     *              -s 显示指定用户账号的状态
     *
     *          29) usermod 修改用户属性
     *              usermod d 指定用户登入时的主目录
     *                      -e 账号终止日期
     *                      -g 指定账户所属的用户组
     *                      -G 指定账户所属的附加组
     *                      -s 指定账户登录后所属的shell
     *                      -u 指定用户的ID号
     *                      -l 新用户名
     *          30) userdel 删除用户
     *              userdel -r 删除用户主目录及本地邮件文件或目录
     *              userdel -f 删除用户登录主目录以及目录中的所有文件
     *          31) su root 切换用户
     *              exit    返回本来的用户
     *          32) id 用户名 查看用户的uid,gid和用户所属用户组的信息
     *          33) whoami 查看当前用户名
     *          34) w      查看当前登录系统用户的详细信息
     *          35) groupadd 新建群组(超级用户可用)
     *                     -g 指定用户组ID
     *                     -o 允许组id号不唯一
     *          36) groupmod 修改用户组的属性
     *                     -g 指定新的用户组ID
     *                     -n 指定新的用户组名字
     *                     -o 允许组ID号不唯一
     *          37) groupdel 删除指定用户
     *          38) chmod 修改文件的访问权限
     *                rwx                    rwx                rwx
     *                文件所有者的的访问权限     组用户的访问权限      其他用户的访问权限
     *
     *                对象   u 文件所有者、 g 同组用户、 o 其他用户
     *                操作符 +增加、 -删除、 =赋予
     *                权限   r读取、 w写入、 x删除、 s设置用户ID位
     *                示例
     *                chmod g-w file
     *                取消同组的用户对file文件的写入权限
     *
     *                chmod 755 pick  rwx r-x r-x
     *                将pick文件的权限设置为文件所有者可读可写可删除、组用户与其他用户可读、可删除
     *
     *           39) chown 更改指定文件的所有者
     *                 -c  显示更改的部分信息
     *                 -f  忽略错误的信息
     *                 -h  修复符号链接
     *                 -R  处理指定目录及其子目录下的所有文件
     *                 -v  显示详细的处理信息
     *                 -deference 作用于符号链接的指向，而不是链接文件本身
     *
     *                 示例
     *                 chown hellen ex1
     *                 将ex1文件的所有者更改为ex1
     *
     *           40) chgrp 更改指定文件的所属群组
     *                    -c  显示更改的部分信息
     *                    -f  忽略错误的信息
     *                    -h  修复符号链接
     *                    -R  处理指定目录及其子目录下的所有文件
     *                    -v  显示详细的处理信息
     *                    -deference 作用于符号链接的指向，而不是链接文件本身
     *           41) gcc GUN compile collection  GUN项目编译集
     *                    cpp 预处理器
     *                    gcc (c编译器) 、g++ (C++ 编译器)
     *           42) 源文件的处理流程
     *               源文件 -> 预处理 -> 编译 -> 汇编 -> 链接 -> 可执行
     *                 .c  -> cpp -o hello.i hello.c  //预处理
     *                     -> ccl -o hello.s hello.i  //编译
     *                     -> as -o hello.o hello.s   //汇编
     *                     -> ld -o hello hello.o     //链接
     *           43) gcc 编译可执行文件
     *                  -o 指定输出文件名称
     *                  示例
     *                  gcc main.c -o main
     *           44) gcc 编译生成.o文件
     *                已有四个.o文件
     *                example.o
     *                add.o
     *                modify.o
     *                delete.o
     *
     *                gcc example.o add.o modify.o delete.o -o example
     *
     *            45) gcc -D #DEFINE 定义一个变量
     *                gcc -D PI=3.141596 main.c
     *
     *
     *            46) gcc -l    指定头文件的搜索路径
     *                    -w    禁止输出警告信息
     *                    -Wall  打开所有警告选项，输出警告信息
     *                gcc helloworld.c -l /user/include -o helloworld
     *
     *            47)  把 .c 编译成 .o
     *                 gcc -c increase.c -o increase.o
     *
     *                 把 .o 归档成 静态库 .a
     *                 ar -r libincrease.a increase.o
     *
     *                 静态库和其他源文件链接成可执行文件
     *                 gcc main.c -L -static -o main
     *
     *
     *             48) -W 禁止打印所有警告信息
     *                 -Wall 打印所有警告信息
     *
     *             49) 把.c 编译成 .o
     *                 gcc -c increase.c -o increase .o
     *                 把.o 归档成静态库 .a
     *                 ar -r libincrease.a increase.o
     *                 静态库和其他源文件链接成可执行文件
     *                 gcc main.c -L -static -o main
     *
     *            50) 生成动态链接库
     *                gcc -shared -fPIC -o libinc.so increase.c
     *
     *                动态链接库的名字必须以lib开头.so结尾，这是linux上的强制约束
     *                -shared 生成共享文件
     *                -fPIC 生成位置独立的代码，此类代码可在不同的进程间共享
     *
     *            51) -L dir 在dir目录中搜索动态库
     *                gcc main.c -o main -linc -L./

     *
     *
     *
     *
     *
     *
     *
     *    手动分界线--------- https://www.bilibili.com/video/BV1Hh4y1t76g/?spm_id_from=333.788&vd_source=f4f4350ec2de6a5e49222861f7129bae ----- Ble系列课
     *
     */
    Category(
        "Android 音视频开发",
        Item("Android Jni C++ 日志打印","https://blog.csdn.net/wenzhi20102321/article/details/136419367","Android Jni添加打印（C++打印）","Android Jni添加打印（C++打印）", arrayListOf()),
    ),

    )