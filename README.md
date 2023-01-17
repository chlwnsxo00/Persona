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





