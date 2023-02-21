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

 # 4주차 - jsoup을 이용한 웹 크롤링 기능 구현
 
 저는 firebase를 이용한 회원가입 및 로그인 기능과 KakaoLoginAPi를 이용한 간편로그인 기능의 구현을 마치고 이제 Jsoup을 이용한 웹 크롤링을 구현하려 합니다.
 
 저는 크롤링 기능을 앱에 구현하며 다들 coroutine을 사용한다는 것을 알았고 이에 대해 설명하려 합니다.
 
 일단 코루틴은 안드로이드 비동기 프로그래밍으로 사용됩니다.
 
 안드로이드 비동기 프로그래밍에는 콜백이나 Rx를 이용하는 방식도 있지만 코루틴을 사용할 시의 여러가지 장점으로 코루틴을 주로 사용합니다.
 
 코루틴의 경우는 실행중인 쓰레드를 blocking 하지않고 중단할 수 있습니다. 이를 통해 단일 쓰레드에서 많은 코루틴을 사용할 수 있습니다. 

코루틴은 일반 함수를 기반으로 빌드됩니다.

그리고 invoke(또는 Call) 과 suspend 함수와 resume 함수를 추가로 사용합니다.

suspend함수를 사용하면 현재 coroutine을 일시중지하 모든 로컬 변수를 저장합니다.

그리고 resume함수를 사용하면 저장된 위체부터 정지된 코루틴을 계속 실행합니다.

coroutine을 시작하는 방법에는 launch와 async가 있습니다.

launch를 사용하면, 새 코루틴을 시작하고 호출자에게 결과를 반환하지 않습니다. '실행 후 삭제'로 간주되는 모든 작업은 launch를 사용하여 시작할 수 있습니다.

async는 새 코루틴을 시작하고 await라는 정지 함수로 결과를 반환하도록 허용합니다.

보통 일반 함수는 await를 호출할 수 없으므로 일반 함수에서 새 코루틴을 launch해야 합니다. 

async는 다른 코루틴 내부에서만 사용하거나 정지 함수 내에서 병렬 분해를 실행할 때 사용합니다.

후기 : 안드로이드 분야에서는 코루틴을 적절하게 잘 사용하는 것이 중요하다고 들었기에 심도깊게 공부해볼 생각입니다.

# 5주차 - 크롤링 앱 개발 마무리

![image](https://user-images.githubusercontent.com/31373739/220092508-642b6b9e-c74e-4b23-8765-0875bbc2a02c.png)

<Jsoup을 활용해 웹사이트에서 크롤링한 후 정보들을 item형식으로 만들어서 Recyclerview로 표현한 에뮬레이터 사진>

```c

private fun crawlingstart(v: View) {    //크롤링하는 함수
        Thread(Runnable {       //네트워크 작업을 할때는 반드시 비동기로 해야함 (아니면 NetworkException 오류뜸)
            val itemList = ArrayList<Items>()
            val doc = Jsoup.connect("https://www.filmmakers.co.kr/actorsAudition").get()
            val elements : Elements = doc.select(".mobile-padding").select("#board-list")
            // mobile-padding 클래스의 board-list의 id를 가진 것들을 elements 객체에 저장
            /*
            크롤링 하는 법 : class 는 .(class) 로 찾고 id 는 #(id) 로 검색
             */
            for(elements in elements){  //elements의 개수만큼 반복
                val href = elements.select("a.block").attr("href")       // 해당 itemlist 클릭 시 팝업할 상세 페이지URL
                val firstRow = elements.select(".block strong").text()      // 글 제목과 콘텐츠 종류
                val time = elements.select("span.content.date").text()      // 글 업로드 시간
                val secondRow = elements.select("td.mobile-nobold").text()      // 콘텐츠(제작, 작품제목, 배역, 모집 배우 성별)
                itemList.add(Items(firstRow, time, secondRow,href))     //위에서 크롤링 한 내용들을 itemlist에 추가
            }

            menuActivity.runOnUiThread(kotlinx.coroutines.Runnable {        //itemlist에 추가한 내용들을 UI에 적용하기 위해 실행
                v.findViewById<RecyclerView>(R.id.rv_item).layoutManager = LinearLayoutManager(menuActivity, LinearLayoutManager.VERTICAL, false)
                v.findViewById<RecyclerView>(R.id.rv_item).adapter = itemAdapter(itemList)
            })
        }).start()
    }

```

이번 주 모임 전까지 Jsoup을 활용해 크롤링을 해 RecyclerView에 표현하는 것뿐만 아니라 Recycler view의 itemlist를 클릭하면 상세 페이지를 연결시켜 줄 생각이었다.
현재까지는 .apply를 통해 안에 itemlist의 onClickListener를 만들어 해당 아이템 리스트를 클릭하면 첫째줄과 둘째줄, 시간을 크롤링 할 때 상세 페이지 URL을 같이 크롤링해 intent를 통해 웹 페이지에 연결해 줄 생각이었다.

하지만 itemadapter에서 .apply를 통해 startActivity가 실행되지 않아 어려움을 겪고 있다.

모각소가 끝난 이후에도 캐스팅 부분또한 크롤링해보고 찜기능과 커뮤니티 기능을 만들어 출시를 해볼 생각이다.

# 마무리 정리

이번 모각소를 통해 Android 개발에 대한 여러가지 기능에 대해 공부하고 웹 크롤링을 구현하고 표현하는 프로젝트를 진행했습니다.

웹 크롤링 기능을 구현하면서 로그인 기능을 구현하는 것과 깃 허브에서 Jsoup을 이용해 배운 내용은 Firebase의 authentication 기능을 활용해 로그인과 회원가입 기능을 구현했습니다.

위의 과정을 통해 gradle에 대해 알게되었고 외부 API를 사용하는 법에 대해 알게되었습니다.

또한 카카오톡의 로그인 API를 이용해 간편 로그인 기능을 구현해 보았습니다.

이를 통해 토큰 인증 방식에 대해 알게 되었습니다.

![image](https://user-images.githubusercontent.com/31373739/220356997-b13cfa36-ed4c-4690-b7fd-725dad17c5bb.png)

카카오 토큰 인증은 위와 같은 방식으로 진행되며, 이를 이해하고 카카오 developers 문서를 따라 각 기능을 구현하는 법을 배우고 적용해 구현에 성공했습니다.

또한 이후 bottomNavigation을 통해 크롤링한 정보를 보여주는 Fragment와 사용자 정보를 보여주는 Fragment와 이후 제작할 캐스팅 정보와 찜기능 그리고 커뮤니티 기능을 넣을 Fragment들을 만들었습니다.

이를 통해 Fragment에 대해 알고, 이를 구현하면서 Fragment의 특징이나 구현하는 법에 대해 알게되었습니다.

Fragment의 경우 Activity 내부에서 사용가능했던 메소드들을 사용할 수 없는 경우가 많습니다. 

그 이유는 Fragment가 Context를 상속받지 않기 때문입니다.

```
private val menuActivity: MenuActivity by lazy {
        context as MenuActivity
    }
```

이를 해결하기 위해 Context를 할당할 변수를 프로퍼티로 선언함으로서 해결했습니다.

이후 크롤링 기능을 제작하며 github에서 오픈소스를 사용하는 법을 배우게 되었습니다.

그리고 Jsoup을 통해 크롤링한 내용들을 표현하기 위해 RecyclerView를 이용했으며 이를 통해 RecyclerView의 작동방식이나 구현방법을 알게되었습니다.

RecyclerView는 item들을 나열할 수 있는 viewGroup같은 view입니다.

이후 item의 xml을 만들고 이를 adapter에 연결하고 adapter를 recyclerview에 연결하며 viewHoler를 만들어 item들을 recyclerView에 스크롤 형식으로 볼수 있도록 합니다.

이렇게 RecyclerView과 item, itemAdapter를 만들고 크롤링을 한 내용을 RecyclerView로 확인하려고 하면서,

크롤링같은 Network작업은 비동기를 필수로 한다는 것을 알게되었고, 이를 통해 비동기 종류나 사용방법에 대해 공부하는 계기가 되었습니다.

비동기의 종류에는 크게 Callback, rxKotlin, coroutine 3종류가 있습니다.

비동기는 위 순서대로 발전해왔다고 알고있으며, 이 중 coroutine은 쓰레드 작업을 할 때 동시성을 가지고 있기에 Blocking time이 없어 굉장히 가볍다는 것을 알게되었습니다.

이번에 구현하면서 coroutine을 사용하며 공부하려했지만, coroutine이 무엇인가에 대해서는 많이 알게된 느낌이지만 사용법에서는 아직 헷갈리는 부분이 많습니다.

이후 coroutine과 더불어 여러가지 추가 기능을 개발하며 공부를 이어갈 생각입니다.

+ 프로젝트와 별개로 공부한 내용들입니다.
안드로이드에서 Data를 저장하는 방법에는 크게 SharedPreference를 통해 파일을 만들고 이를 통해 data를 저장하는 방법, Room을 통해 SQLite를 쉽게 사용해 localDB를 활용하는 방법, 그리고 외부 서버를 이용하는 방법입니다.

이 중 SharePreference를 활용해 개인 수첩 앱을 만드는 토이 프로젝트를 진행했으며,

Room을 활용해 히스토리 기능을 가진 계산기를 만드는 토이프로젝트를 진행하였고,

이번 프로젝트를 진행하며 firebase를 이용해 회원 정보를 저장해보았습니다.







