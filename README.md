# 1주차 - 안드로이드 UI
안드로이드에서는 XML파일에서 UI를 선언합니다. Android studio에서 드로그 앤 드랍 방식을 이용해 XML 레이아웃을 빌드하거나, 직접 코딩을 해 빌드 할 수 있습니다.

![image](https://user-images.githubusercontent.com/31373739/211561332-c0f2d707-d734-4dc3-9b30-ad62b7f58d34.png)

위의 사진은 LinearLayout를 포함하는 XML 레이아웃으로 LinearLayout은 TextView와 Button을 포함합니다.
또한 width와 height를 사용해 View의 크기를 설정하고 text를 통해 View 속에 문자를 삽입해 보여줄 수 있습니다.
또한 id를 설정해 이후 Activity에서 해당 View에 특정 이벤트를 설정해 줄 수 있습니다.

먼저 Kotlin으로 작성된 Activity를 살펴보면

fun onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_layout)
}

이러한 형식으로 Activity.onCreate() 콜백 구현의 앱 코드에서 레이아웃 리소스를 로드합니다.

val myButton: Button = findViewById(R.id.my_button)

그리고 setContentView()의 아래에 위와 같은 코드를 작성해 만약 레이아웃에 my_button이라는 id를 가진 Button이 있다면,
레이아웃에서 해당 View를 불러와 Activity에서 myButton이라는 value로 저장합니다.(var로 선언할 수 있지만 val로 선언하는것이 오류나 보안에 안전함)

my_btn.setOnClickListener {
            //해당 부분에 코드를 작성해 클릭시 이벤트 설정가능
        }

이처럼 Layout을 만들고 layout 속 View들에 각각 id를 설정하고, 이후 activity 파일에서 findViewByID를 이용해 레이아웃과 연결한 후
setOnClickListener와 같은 코드를 이용해 클릭 시 이벤트 발생과 같은 여러 상호작용 기능을 부여할 수 있다.

![image](https://user-images.githubusercontent.com/31373739/211566508-815b50db-2461-4315-864b-c21df80f3fc5.png)

위의 사진에서 설명하는 View는 일반적으로 사용자가 보고 상호 작용할 수 있는 것을 그립니다.
반면 ViewGroup은 레이아웃 구조를 정의하는 보이지 않는 컨테이너입니다.
이를 통해 View를 넣으려면 먼저 ViewGroupt 정의한 후에 ViewGroupt 속에 View의 삽입이 가능하고 ViewGroupt 속에 ViewGroup을 삽입하는게 가능하다는 것을 알 수 있습니다.

![image](https://user-images.githubusercontent.com/31373739/211568031-185cc4ed-08f5-429d-b96e-5126afae9a0d.png)

일반적인 레이아웃은 위의 그림에 나타난 LinearLayout(선형 레이아웃), ConstraintLayout(상대 레이아웃), 웹 보기가 있습니다.

ConstraintLayout을 사용할 때에는 하나 이상의 수평 제약 조건과 수직 제약 조건을 추가해야 합니다.
각 제약 조건들은 다른 View들, 상위 레이아웃 또는 보이지 않는 가이드라인에 대한 연결 또는 정렬을 나타냅니다.

이번 프로젝트에 사용할 RecyclerView는 한 화면에 표시되기 힘든 많은 수의 데이터를 스크롤 가능한 리스트로 표시해주는 ViewModel입니다.
RecyclerView는 스스로 View이기도해서 RecyclerView는 레이아웃 속에 추가되어야 합니다.

RecyclerView을 사용하려면 몇 가지 작업을 수행해야 합니다.

  1.목록 또는 그리드의 모양을 결정합니다. 일반적으로 RecyclerView 라이브러리의 표준 레이아웃 관리자 중 하나를 사용할 수 있습니다.

  2.목록의 각 요소가 어떻게 보이고 작동하는지 디자인합니다. 이 디자인을 기반으로 ViewHolder클래스를 확장합니다. 
    ViewHolder 버전은 목록 항목에 대한 모든 기능을 제공합니다. 뷰 홀더는 View를 둘러싼 래퍼 이며 해당 뷰는 RecyclerView에서 관리합니다 .

  3.Adapter데이터를 보기와 연결하는 ViewHolder를 정의하십시오 .
  
  # 2주차 - 안드로이드 UI제작 및 firebase를 통한 회원가입 및 로그인 기능 구현
  ![image](https://user-images.githubusercontent.com/31373739/212929050-2d162d8a-65c0-46b2-b6c2-c8cb4db109d8.png)
  
  ![image](https://user-images.githubusercontent.com/31373739/212928929-65f0beb5-11b4-481a-84fb-5b0a15a33002.png)
  
  위의 사진처럼 현재 앞으로 구현할 모집공고 확인, 캐스팅, 찜기능, 커뮤니티와 내 계정을 BottomNavigation을 통해 각각의 서비스 전환이 이루어 지게 할 것이다.
  먼저 5개의 기능 중 먼저 구현하고 있는 것이 firebase를 통해 회원가입 및 로그인 기능이다.
  그 이외에도 카카오톡이나 구글과 같은 대기업의 RestfulAPI를 이용해 간편 로그인 기능도 구현해 볼 생각이다.
  
  이번주에 앱 제작을 하며 알게된 내용은 BottomNavigation에 사용되었던 Fragment 기능과 간편로그인 기능을 구현하며 배운 Restful API와 Server와 연동시키는 법 등이다.
  그 중 Fragment에 대해 설명해 보겠다. 
  
  Fragment는 하나의 레이아웃에 종속된 레이아웃의 일부라고 해야할까?
  BottomNavigation을 살펴보면 아래의 Navigation을 클릭한다고 해서 전체화면이 바뀌지 않는다.
  BottomNavagation과 Toobar를 제외한 중간의 일부 레이아웃만이 변하게 된다.
  이처럼 Fragment를 통해 레이아웃의 전체가 아닌 일부만 바뀌게 구현할 수 있다.
  이를 사용하며 Activity와 Fragment에서의 구현 방식이 달라 이를 새로 배우며 구현하느라 힘들었다.
  
   후기 : 모각코를 통해 매 주 목표를 정하고 그만큼 구현을 해 나가고, 그 이후에 다음 주 계획을 설정하고 필요할 내용들을 공부하는 등 매주 시간을 생산성있게 보내는 것 같아 의미가 있다.

 # 3주차 - 안드로이드 UI제작 및 firebase를 통한 회원가입 및 로그인 기능 구현
 
 나는 LoginFragment와 ProfileFragment를 각각 만든 후 LoginFragment에서 로그인 과정을 거친 후 성공하면 ProfileFragment로 넘어가고 이후에도 이후 BotttomNavigation에서 Fragment전환을 할때에도 LoginFragment가 아닌 ProfileFragment로 전환하도록 해 로그인 과정을 구현하려고 했다.
하지만 KakaoLoginAPI를 통해 서버에서 Token을 받아와도 위의 과정을 구현하기에 기존의 ActivityManager에서의 방식과의 차이 등으로 어려움을 겪었다.
![image](https://user-images.githubusercontent.com/31373739/215776387-3282ada0-f1cc-4c66-a164-0b1bc375fb2e.png)

그러나 다른 사람들은 어떻게 구현했는지 계속 조사했고, 이를 통해 한 Fragment에 Login화면과 Profile화면을 겹쳐서 구현하고
Profile화면은 visibility를 gone으로 해놓고 이후 성공했을때 Login화면을 visible을 false로 바꾸고 Profile화면의 visible의 화면을 true로 바꾸는 방식을 사용한다는 것을 알았다.

그래서 현재 전에 하던 방식에서 이 방식을 채택해 구현해하려고 바꾸고 있는 중이다.

(+)모각코의 목표 계획과는 상관 없지만 개인적으로 Android 개발에 대해 공부하며 DB를 사용하는 방식에 대해 배웠다. 
Android에서는 DB를 활용하는 방법에는 크게 3가지가 있는데 첫번째가 외부 DB를 활용하는 것이고,
두번째가 localDB를 활용하는 것,
마지막이 앱속 file을 만들고 그 파일을 DB로 활용하는 방식이다.

현재 만드는 어플의 경우 첫번째 방식을 활용하여 개발할 것이다.

2번째 방식의 경우는 SQLiteAPI를 활용하는 방식도 있지만 Room을 활용하면 SQL 쿼리의 컴파일 시간 확인, 반복적이고 오류가 발생하기 쉬운 상용구 코드를 최소화하는 편의 주석, 간소화된 데이터베이스 이전 경로와 같은 장점들이 있기에 Room을 활용해 LocalDB를 사용하는 방식을 공부했다.

Room은 데이터베이스 클래스, 데이터 항목, 데이터 엑세스 객체(DAO)로 구성된다.

데이터베이스 클래스: 데이터베이스를 보유하고 앱의 영구 데이터와의 기본 연결을 위한 기본 액세스 포인트 역할을 합니다.

데이터 항목: 앱 데이터베이스의 테이블을 나타냅니다.

데이터 액세스 객체(DAO): 앱이 데이터베이스의 데이터를 쿼리, 업데이트, 삽입, 삭제하는 데 사용할 수 있는 메서드를 제공합니다.

![image](https://user-images.githubusercontent.com/31373739/215787850-41848a95-6580-42ea-9825-4b78070192cf.png)

데이터베이스 클래스는 데이터베이스와 연결된 DAO 인스턴스를 앱에 제공합니다. 
그러면 앱은 DAO를 사용하여 데이터베이스의 데이터를 연결된 데이터 항목 객체의 인스턴스로 검색할 수 있게 됩니다. 
앱은 정의된 데이터 항목을 사용하여 상응하는 테이블의 행을 업데이트하거나 삽입할 새 행을 만들 수도 있습니다.

(+)같이 모각코를 하는 학우의 발표를 듣고 Android를 개발하는 방식이 내가 하고 있는 방식이 아닌 jetpack compose방식도 있다는 것을 알게되었다.

이러한 방식을 통해 xml을 없애고 Compose에 Activity와 xml에서 하던 일은 합친 방식이다.

개인적으로 compose 방식을 채택하면 장점으로는 화면이 많아졌을 때 많은 Activity와 xml를 왔다갔다 하며 수정해야하는 번거로움을 줄일 수 있다.

단점으로는 한 파일에 UI와 기능을 모두 구현해야하기에 파일의 크기가 커지고 가독성이나 한 파일에서 수정해야하는 부분을 찾기 힘들다.

Airbnb나 google play 등 여러 어플이 compose 방식으로 개발되었고, 
구글이 관련 어플들을 compose방식으로 개발하는 것을 보면 앞으로 Android 개발이 compose 방식이 주류가 될 수 있다고 생각한다.




