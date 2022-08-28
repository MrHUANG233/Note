## 1.属性

```
properties{
	_MainTex("Texture",2D)="white"{}
	_Color("color",Color)=(0,0,0,0)
	_Int("Int",Int)=1
	_Float("Float",Float)=1.0
	_Range("Range",Range(0.0,1.0))=0.1
	_Cube("Cube",Cube)="white"{}
	_3D("3D",3D)="black"{}
}
```

## 2.SubShader

### RenderSetup用于逐片元操作的流程，如关闭深度读写，开启混合模式

```
ZWrite off//关闭深度写
```

### Tags设置渲染方式

- ```
  Queue//指定渲染队列，确保透明物体在不透明物体之后渲染
  Tags{"Queue"="Transparent"}
  ```

- ```
  RenderType//对着色器类型分类，用于着色器替换
  Tags{"RenderType"="Opaque"}
  ```

- ```
  DisableBatching//是否批处理
  Tags{"DisableBatching"="True"}
  ```

- ```
  ForceNoShadowCasting//控制该物体是否会投射阴影
  Tags{"ForceNoShadowCasting"="True"}
  ```

- ```
  IgnoreProjector//
  Tags{"IgnoreProjector"="True"}
  ```

- ```
  CanUseSpriteAtlas//用于精灵时标签设置为"False"
  
  ```

- ```
  PreviewType//材质预览方式"Plane""SkyBox"
  ```

## 3.内置变换矩阵
```
UNITY_MATRIX_MVP
UNITY_MATRIX_MV
UNITY_MATRIX_P
UNITY_MATRIX_VP

UNITY_MATRIX_T_MV
UINTY_MATRIX_IT_MV

_Object2World == unity_ObjectToWorld
_Wrold2Object

```
## 3.常用函数
https://www.cnblogs.com/victor2k/articles/13677342.html
```
abs(x) 返回输入参数的绝对值
acos(x) 反余切函数，输入参数范围为[-1,1]，返回[0,π]区间的角度值
all(x) 如果输入参数均不为 0，则返回 ture；否则返回 flase。&&运算
any(x) 输入参数只要有其中一个不为 0，则返回 true。||运算
asin(x) 反正弦函数,输入参数取值区间为[−1,1]，返回角度值范围为[−π/2 ,π/2 ]
atan(x) 反正切函数，返回角度值范围为⎡−π/2 ,π/2 ⎤
atan2(y,x) 计算 y/x 的反正切值。实际上和 atan(x)函数功能完全一样，至少输入参数不同。atan(x) = atan2(x, float(1))
ceil(x) 对输入参数向上取整。例如：ceil(float(1.3)) ，其返回值为 2.0
clamp(x,a,b) 如果 x 值小于 a，则返回 a；如果 x 值大于 b，返回 b；否则，返回 x
cos(x) 返回弧度 x 的余弦值。返回值范围为[−1,1]
osh(x) 双曲余弦（hyperbolic cosine）函数，计算 x 的双曲余弦值
cross(A,B) 返回两个三元向量的叉积(cross product)。注意，输入参数必须是三元向量
degrees(x) 输入参数为弧度值(radians)，函数将其转换为角度值(degrees)
determinant(m) 计算矩阵的行列式因子
dot(A,B) 返回 A 和 B 的点积(dot product)。

exp(x) 计算ex 的值，e= 2.71828182845904523536
exp2(x) 计算2x 的值
floor(x) 对输入参数向下取整。例如 floor(float(1.3)) 返回的值为 1.0；但是 floor(float(-1.3))返回的值为-2.0。
fmod(x,y) 返回 x/y 的余数。如果 y 为 0，结果不可预料
frexp(x, out exp) 将浮点数 x 分解为尾数和指数，即 x = m* 2^exp，返回 m，并将指数存入 exp 中；如果 x 为 0，则尾数和指数都返回 0
frac(x) Returns the fractional portion of a scalar or each vector component
isfinite(x) 判断标量或者向量中的每个数据是否是有限数，如果是返回 true；否则返回 false;无限的或者非数据(not-a-number NaN)
isinf(x) 判断标量或者向量中的每个数据是否是无限，如果是返回 true；否则返回 false;
isnan(x) 判断标量或者向量中的每个数据是否是非数据(not-a-number NaN)，如果是返回 true；否则返回 false;
ldexp(x, n) 计算x∗2n 的值
lerp(a, b, f) 计算(1− f )∗ + ∗a b f 或者a+ f ∗ −(b a)的值。

计算两个矩阵相乘，如果 M 为 AxB 阶矩阵，N 为 BxC 阶矩阵，则返回 AxC 阶矩阵。下面两个函数为其重载函数。
mul(M, v)
计算矩阵和向量相乘
mul(v, M)
计算向量和矩阵相乘
noise( x)
噪声函数，返回值始终在 0，1 之间；对于同样的输入，始终返回相同的值（也就是说，并不是真正意义上的随机噪声）。
pow(x, y)

CG函数
distance( pt1, pt2)
两点之间的欧几里德距离（Euclidean distance）
faceforward(N,I,Ng)
如果Ng I• < 0 ，返回 N；否则返回-N。
length(v)
返回一个向量的模，即 sqrt(dot(v,v))
normalize( v)
归一化向量
reflect(I, N)
根据入射光方向向量 I，和顶点法向量 N，计算反射光方向向量。其中 I 和 N 必须被归一化，需要非常注意的是，这个 I 是指向顶点的；函数只对三元向量有效
refract(I,N,eta)
计算折射向量，I 为入射光线，N 为法向量，eta 为折射系数；其中 I 和 N 必须被归一化，如果 I 和 N 之间的夹角太大，则返回（0，0，0），也就是没有折射光线；I 是指向顶点的；函数只对三元向量有效
```
## 3.顶点着色器

## shader时间
···
_Time (t/20,t,t*2,t*3) (float4类型)
_CosTime (t/8,t/4,t/2,t) (float4)
_SinTime (t/8,t/4,t/2,t) (float4)
unity_DeltaTime (dt,1/dt,smoothDt,1/smoothDt) (float4类型，增量时间)
···

![image-20220513234604288](C:\Users\19350\AppData\Roaming\Typora\typora-user-images\image-20220513234604288.png)

```
struct appdata{//(模型坐标)
	float4 vert:POSITION;//顶点位置
	float2 texcoord:TEXCOORD0;//纹理坐标
	float3 normal:NORMAL;//法线
	float3 tangent:TANGENT;//切线
	float4 color:COLOR;//顶点颜色
};

v2f vert(appdata v)
{
	
}
```



## 4.片元着色器

```
struct v2f{
	float4 vert:SV_POSITION;//裁剪空间坐标
	float2 texcoord:TEXCOORD0;
	float4 color:COLOR0;//可以传递一组值
};

fixed4 frag(v2f i):SV_TARGET
{

}
```

矩阵变换坐标系转换：https://www.bilibili.com/read/cv14408919

![image-20220513214850583](C:\Users\19350\AppData\Roaming\Typora\typora-user-images\image-20220513214850583.png)

![image-20220513214910549](C:\Users\19350\AppData\Roaming\Typora\typora-user-images\image-20220513214910549.png)

