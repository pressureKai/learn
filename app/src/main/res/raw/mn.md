# **反射与注解**

Target 详解

```java
//@Target 表示注解作用的对象
@Target({ElementType.FIELD})
public void @interface BindView {

}

public enum ElementType {
    TYPE,            //接口、类、枚举
    FIELD,           //字段、枚举常量
    METHOD,          //方法
    PARAMETER,       //方法参数
    CONSTRUCTOR,     //构造方法
    LOCAL_VARIABLE,  //局部变量
    ANNOTATION_TYPE, //注解
    PACKAGE,         //包
    TYPE_PARAMETER,
    TYPE_USE,
    MODULE,
    RECORD_COMPONENT;

    private ElementType() {
    }
}
```

  Retention 详解

```java
//@Rentention 注解信息保存的编译级别
@Rentention(RetentionPolicy.RUNTIME)
public void @interface BindView {

}


public enum RetentionPolicy {
    SOURCE,  //源码
    CLASS,   //字节码
    RUNTIME; //运行时

    private RetentionPolicy() {
    }
}
```

注解传参

```java
@Target（{ElementType.FIELD}）
@Rentention(RetentionPolicy.RUNTIME)
public void @interface BindView {
    String value();
    int id();
}

//调用
@BindView(id = 1,value = "跳槽工资涨一倍")
TextView textView;
```

 **注解的应用场景**

- 注解结合注解处理器（APT **Annotation Processor Tool**）在代码编译阶段生成功能性代码 **butternife、dagger2、databindding**
  
  ```java
  // Annotation Processor Tool 使用
  // 在项目中新建一个 （java 模块） annotations 模块，在build.gradle 文件中的dependencies 添加依赖代码
  dependencies {
      annotationProcessor 'com.google.auto.service:auto-service:1.0-rc4'
      compileOnly 'com.google.auto.service:auto-service:1.0-rc4'
  
      implementation project(path:':annotations')
  }
  
  
   //在项目中新建 AnnotationCompiler.java 文件
   @AutoService(Process.class)
   public class AnnoatationCompiler extends AbstactProcessor
   {
  
  
   //支持的版本
   @Override
   public SourceVersion getSupportedSourceVersion()
   {
     return SourceVersion.latestSupported();
   }
  
  
   //能用来处理哪些注释
   @Override
   public Set<String> getSupportAnnotationTypes()
   {
    Set<String> types = new HashSet<>();
    //getCanoicalName() 获取该类的标准名称
    types.add(BindView.class.getCanonicalName());
    return types;
   }
  
  
  
   // 定义一个用来生成APT目录下面的文件对象
   Filer filer；
   @Override
   public synchronzied void init(
          ProcessingEnvironment processingEnv){
          super.init(processingEnv);
          filer = processingEnv.getFiler();
   }
  
  
  
  
   @Override
   public boolean process(
      Set<? extends TypeElement> annotations,
      RoundEnvironment roundEnvironment)
  {
  
  //日志输出
  processingEnv
     .getMessager()
     .printMesssage(Diagnostic.Kind.NOTE,
        "note log"+annotatios);
  
  
  // TypeElement       类      
  // ExecutableElement 方法      
  // VariableElement   属性      
  //获取App中所有用到了BindView注解的对象      
  Set<? extends Element> elementsAnnotatedWith =
   roundEnvironment.getElementsAnnotatedWith(BindView.class);
  
  
  //开始对elementsAnnotatedWith进行分类
  Map<String,List<VariableElement>> map = new HashMap();
  for(Element elment : elementsAnnotatedWith){
  
    VariableElement variableElement = (VariableElement) element;
    
    //获取使用注解的Activity名称
    String activityName = 
  variableElement.getEnclosingElement()
  .getSimpleName()
  .toString();
  
    //通过ActivityName从分类列表中获取注解元素列表
    List<VariableElement> variableElements = map.get(activityName);
    //判断注解元素列表是否为空,为空的话代表没有获取过该Activity的注解元素，为第一次获取并初始化一个列表，放置在map中。
    if(variableElements == null){
       variableElements = new ArrayList();
       //放置到分类map中
       map.put(activityName,variableElements);               
    }
  
    variableElements.add(variableElement);
  
  }
  
  
  
  
  
  if(map.size > 0)
  {
    Writer writer = null;
    Iterator<String> iterator = map.keySet().iterator();
    while(iterator.hasNext())
    {
     String activityName = iterator.next();
  
     List<VariableElement> variableElements 
       = map.get(activityName);
  
     TypeElement enclosingElement  =
       (TypeElement) variableElments.get(0).getEnclosingElement();
  
     //processingEnv AbstactProcessor 中的成员变量，在此用于获取包名
     String packageName = processingEnv
     .getElementUtils()
     .getPackageOf(enclosingElement)
     .toString();
  
     try{
        JavaFileObject sourceFile =
         filer.createSourceFile(
           packageName + "." + activityName + "_ViewBinding");
         writer = sourceFile.openWriter();
         writer.write("package  "+packgeName + ";\n");                 
         writer.write("import "+packgeName + ".IBinder;\n");
  
         writer.write("public class "
            + activityName 
            + "_ViewBinding implements IBinder<" 
            + packageName + "." + activityName +">{\n");
  
         writer.write("@Override\n"+" public void bind("+ packgeName + "." + activityName + " target){" )
  
         for(VariableElement variableElement : variableElements){
           //得到名字
           String variableName = variableElement.getSimpleName().toString();
           //得到ID
           int id = variableElement.getAnnotation(BindView.class).value();
           //得到类型
           TypeMirror typeMirror = variableElement.asType();
         }
  
         writer.write("\n}}");
    }catch(Exception e){
         e.printStackTrace();             
    } finally {
       if(writer != null){
        try{
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   }
  }
  
   return false;
  
  }
  
  
  
  
  
  
  
  
  
  //通过反射调用
   public static void bind(Activity activity){
     String name = activity.getClass().getName()+ "_ViewBinding";
     try{
        Class<?> aClass = Class.forName(name);
        IBinder iBinder = (IBinder)aClass.newInstance();
        iBinder.bind(activity);
     }catch(Exception e){
        e.printStackTrace();
     }
   }
  
  
  
  
  
  ```

- 注解+代码埋点 **AspactJ、Arouter**
- 注解+反射+动态代理 **Xutils、lifecycle**



```java
//注解多态的实现

@Target({ElementType.ANNOTATION_TYPE})
@Rentention(RetentionPolicy.RUNTIME)
public void @interface EventBase {
   //setOnClickListener 订阅关系
   String listenerSetter();
   //new View.OnClickListener() 事件本身
   Class<?> listenerType();
   // onClick 事件处理程序
   String callbackMethod();
}



@Target({ElementType.MTHOND})
@Rentention(RetentionPolicy.RUNTIME)
@EventBase(listenerSetter = "setOnClickListener",
listenerType = View.OnClickListener.class,
callbackMethod = "onClick"
)
public void @interface OnClick {
     int[] value() default -1;
}





/**
 * 这个类用来代理new View.OnClickListener()对象
 * 并执行这个对象身上的onClick方法
 */
public class ListenerInvocationHandler implements InvocationHandler {

    //需要在onClick中执行activity.click();
    private Object activity;
    private Method activityMethod;

    public ListenerInvocationHandler(Object activity, Method activityMethod) {
        this.activity = activity;
        this.activityMethod = activityMethod;
    }

    /**
     * 就表示onClick的执行
     * 程序执行onClick方法，就会转到这里来
     * 因为框架中不直接执行onClick
     * 所以在框架中必然有个地方让invoke和onClick关联上
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在这里去调用被注解了的click();
        return activityMethod.invoke(activity,args);
    }
}






public class InjectUtils {


 public static void inject(Object context){
    injectClick(context);
 }



 public static void injectClick(Object context){
   //使用注解的Activity
   Class<?> clazz = context.getClass();
   //获取声明的方法
   Method methods = clazz.getDeclaredMethod();

   for(Method method : methods){
     //获取该方法所使用的注解
     Annotation[] annotations = method.getAnnotations();
     //遍历获取到的注解
     for(Annotation annotation : annotations){
       //获取注解的类型
       Class<?> annotationClass = annotation.annotationType();
       //获取EventBase注解类，多态在此EventBase实现
       EventBase eventBase = annotationClass.getAnnotation(
EventBase.class);

       //判断是不是事件处理程序
       if(eventBase == null){
         continue;
       }
       String listenerSetter = eventBase.listenerSetter();
       Class<?> listenerType = eventBase.listenerType();
       String callbackMethod = eventBase.callbackMethod();

       Method valueMethod = null;
       try{
         //获取该注解类中的“value”方法
         valueMethod = annotationClass.getDeclaredMethod("value");

         //反射调用该方法获取控件ID
         int[] viewId = (int[]) valueMethod.invoke(annotation);


         for(int id : viewId){

           Method findViewById =  clazz.getMethod("findViewById",int.class);

           View view = (View)findViewBydId.invoke(context,id);

           if(view == null){
              continue;
           }


           //context === Activity method === 该Activity中使用onClick注解的方法
           ListenerInvocationHandler listenerInvocationHandler 
              = new ListenerInvocationHandler(context,method);


           //new View.OnClickListener() 动态代理
           Object proxy 
            = Proxy.newProxyInstance(
             listenerType.getClassLoader(),
             new Class[]{listenerType},
             listenerInvocationHandler);


           //view.setOnClickListener(new OnClickListener())
           Method onClickMethod = 
view.getClass().getMethod(listenerSetter,listenerType);

            onClickMethod.invoke(view,proxy);
         }
   }catch (Exception e){
         e.printStackTrace();
   }
            }
        }
   }
}
```

- 规范代码参数输入

- 使用注解替代枚举减少程序占用的内存空间
  
  ```java
  enum WeekDay{
      SUNDAY,
      MONDAY
  }
  public void SetCurrentDay(WeekDay weekDay){
  
  }
  
  //调用
  SetCurrentDay(WeekDay.SUNDAY);
  
  //Annotation 优化方案 相对于枚举缩小3倍的内存空间
  private static final int SUNDAY = 0;
  private static final int MONDAY = 1;
  @IntDef({SUNDAY,MONDAY})
  @Target(ElementType.PARAMETER)
  @Retention(RetentionPolicy.SOURCE)
  public @interface WeekDay{
  
  }
  
  public static void setCurrentDay(@WeekDay int currrentDay){
  
  }
  
  //调用
  setCurrentDay(MONDAY);
  ```

# 


