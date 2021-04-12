# 학습 일지

#### Tab 사용하는 것을 습관 들이기

#### 붙여넣기 : 마우스 오른쪽 클릭



## OSPF 개념 및 설정법

### 1. OSPF 개념

- AS(Autonomous System) 내부를 구성하는 내부용 라우팅 프로토콜(IGP : Interior Gateway Protocol)이다. 
- Link State 라우팅 프로토콜입니다. 특히, 최단 경로를 선택하기 위해 다익스트라(Dijkstra)의 SPF(Shortest Path First) 알고리즘을 사용한다.
- RIP과 달리 빠른 재수렴(Fast Reconcergence) 속도를 가지고 있다.
  - OSPF는 변화가 생기면 바로 해당 정보를 전파하기 떄문에 즉시 변경된 라우팅 정보를 반영하여 빠른 Convergence time을 가진다.
    - Convergence time
      - 네트워크의 모든 라우터간에 정보를 주고 받는데 걸리는 시간
- OSPF는 Area라는 개념을 사용하여 네트워크를 더 작은 영역으로 나눈 다음 관리를 하기 때문에 더 효율적인 라우팅, 관리가 가능하다. 따라서, 큰 네트워크에 적합하다.
  - 다른 영역에서 변화가 일어나더라도 라우팅 테이블을 업데이트 하지 않아도 된다.
  - 단, 반드시 백본 영역이 존재해야 하며, 연결되지 못하는 경우에는 Virtual 링크를 통해 연결되어야 한다.
- Stub Area
  - ABR이 내부 라우터에게 외부 경로에 대한 LSA를 차단하고 대신 디폴트 루트를 전달하는 것을 Stub Area라고 한다. Stub Area를 설정하면 1) 라우팅 테이블의 크기를 대폭 감소시켜서 2) 네트워크의 안정성이 확보되며 3) 라우팅 성능도 좋아지고 4) 장애처리가 쉬워진다.
  - 단, 고려해야 할 점은 다음과 같다.
    - 연결된 2개 이상의 라우터에 설정해야한다.
    - 백본 Area의 라우터에는 적용되지 않는다.
    - Virtual Link가 적용된 라우터에는 적용되지 않는다.
    - Stub Area와 Totally Stubby Area는 ASBR 라우터에 적용할 수 없으며 같은 Area에 있는 라우터 모두에게 적용해야 한다.
    - NSSA와 NSSA Totally Stubby Area는 백본 라우터를 제외하고 모든 라우터에게 적용되어 축약 된다.
  - Stub area 유형
    - Stub Area
      - OSPF 경로 코드의 O IA까지만 허용하며, O E1, O E2는 차단한다.
      - 외부 네트워크에 대한 LSA 정보가 없기 때문에 경로 선출이 불가능하므로 ABR이 기본 경로를 대신 알려준다.
    - Totally Stub Area
      - O 타입 이외에 다른 경로를 모두 차단하며 같은 Area 내에 있는 라우터의 Advertisement만 라우팅 테이블에 적용한다.(O IA, O E1, O E2를 차단)
    - NSSA
      - Stub Area에 ASBR을 포함하여 구성하는 방식
      - 외부 네트워크에 대한 Type - 5의 LSA가 내부 라우터로 Advertisement 되지 않으므로 Area 내부에 ASBR 이 있을 경우 외부 네트워크 정보가 Type - 7의 LSA로 Advertisement 될 수 있도록 하는 구성
      - Area 내부에 ASBR이 있는 경우 Stub Area 혹은 Totally Area로 구성할 수 없으므로 NSSA Stub Area를 구성한다.
    - NSSA Totally Stub
      - NSSA와 Totally stub 기능을 합친 구성(O 타입 이외에 다른 경로 모두 차단 + Area 내부의 ASBR을 통해 외부 네트워크 정보를 Type - 7의 LSA로 Advertisement 구성)
- 서브넷을 더 잘개 쪼개는 VLSM을 지원하므로 IP 주소를 효과적으로 사용할 수 있을 뿐 아니라 라우팅 테이블을 줄일 수 있으므로 효율적인 리소스 사용이 가능하다.
- RIP과 달리 홉 카운트에 제한이 없어 네트워크 크기의 제한이 없다.
- 홉 카운트만을 고려하는 RIP과 달리 Link cost 개념으로 다양한 변수를 기반으로 한 케트릭을 산정하여 최단 거리를 구하는 OSPF의 알고리즘 특성상 더 효율적이고 빠른 경로 산출이 가능하다.
- OSPF에서는 기본적으로 네트워크 관리의 책임을 지는 DR과 BDR을 선출한다. 이 후, OSPF에 참여하는 모든 라우터들은 DR과 BDR에 자신의 Link State를 알린다.
  - DR(Designated Router) and BDR(Backup Designated Router)
    - 이렇게 DR, BDR에게만 자신의 Link 정보를 알리는 이유는 모든 라우터와 Link 정보를 교환할 경우 발생하는 트래픽을 줄이고 링크 상태의 Sync 상태를 올바로 관리하는데 있다.
    - DR은 이 정보를 관리하고 링크 상태를 항상 일치시키는 역할을 수행한다.
    - BDR은 DR이 제대로 동작하는지 업무를 제대로 수행하는지를 관찰하다가 DR에게 문제가 발생하면 바로 DR의 역할을 대신 수행한다.
    - OSPF에서는 모든 라우터가 반드시 DR, BDR과 Link State를 Sync(일치)해야 한다. 이것을 Adjancency라고 한다.
    - DR과 BDR은 라우터 ID와 라우터의 Priority를 가지고 선출된다.
  - DR과 BDR의 선출과정
    - 라우터의 default Priority는 1이다.
    - 어떤 라우터가 이보다 높은 Priority를 갖는다면 그 라우터가 DR이되고 그 다음이 BDR로 선정
    - 두 라우터의 Priority가 같다면 라우터 ID가 높은 라우터가 DR이 된다.



### 2. OSPF 설정법

![image-20210409105548276](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409105548276.png)

- enable

- conf t

- router ospf **1**

  - router ospf **[Process ID]**
    - Process ID는 1~65,535 사이의 값을 임의로 부여
    - Process ID는 동일한 라우터에서 복수개의 OSPF를 동작시킬 때 서로 구분하기 위한 목적으로 사용

- (router-id x.x.x.x)

  - OSPF와 같은 link state protocol은 라우팅 정보 전송 시 여러 값들을 전송하는데 이 때,  정보를 전송하는 라우터가 어떤 라우터인지도 알려준다. 이 때 사용하는 값이 라우터 ID이다.
  - 라우터 ID는 주로 루프백 주소로 지정해주며 만약 루프백이 설정되어 있다면 자동적으로 루프백 주소를 라우터 ID로 지정된다.

- netework [광고 대역 주소] [광고 대역의 **와일드 카드 마스크**] [area x]

  ex. network 172.12.0.0 0.0.0.3 area 0

  - Wildcard Mask
    - 와일드카드 마스크는 서브넷 마스크와 표현 방법이 반대이다.
    - network ID를 '0'으로, host ID를 '1'로 표현한다.
  - Area 0
    - Backbone Area
    - 2개 이상의 Area가 존재시 반드시 BA가 존재해야 한다.

- show ip route

  ![image-20210409110029657](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409110029657.png)

  - 라우팅 테이블에 OSPF Inter Area **(O IA)**라는 것은 다른 Area에 속한 네트워크라는 의미이다.
  
  - ![image-20210409174914541](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409174914541.png)
    - '1'은 변동 COST를 의미. '2'는 고정 COST 값을 의미
    
      - 변동 COST라는 의미는 어느 라우터에서 바라보는지에 따라 Metric값이 달라지는 것을 말한다.
    
        ![image-20210411214546141](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411214546141.png)
    
        ![image-20210411214605607](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411214605607.png)
    
      - 고정 COST라는 의미는 어느 라우터에서 바라봐도 Metric 값이 같은 것을 의미한다.
    
        ![image-20210411213635729](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411213635729.png)
    
        ![image-20210411213841720](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411213841720.png)
    
        ===> 다른 라우터에서 같은 목적지를 바라봐도 Metric 값이 동일하다.
    
      - **'redistribute connected metric-type 1 subnets'**라는 명령어를 통해 설정 해준다.
    
        - 따로 설정안해주면 metric type 2가 기본으로 설정됨
    
    - 'E'는 외부 네트워크 재분배, 'N'은 NSSA  외부 네트워크 재분배를 의미 
      - 재분배(Redistribution)
        - 서로 다른 라우팅 프로토콜 사이에서 특정 라우팅 프로토콜이 다른 방법으로 알게 된 경로를 자신의 라우팅 프로세스에 포함시키는 것을 말한다.
        - External Network의 예시
          - BGP 망의 라우팅 정보
          - ISIS 망의 라우팅 정보
          - Static으로 생성된 라우팅 엔트리 정보
          - 라우터와 바로 직결된 Conneted Network이지만 이 링크는 OSPF가 enable되지 않는 경우
      - NSSA
        - Stub Area에 ASBR을 포함하여 구성하는 방식
        - 외부 네트워크에 대한 Type - 5의 LSA가 내부 라우터로 Advertisement 되지 않으므로 Area 내부에 ASBR 이 있을 경우 외부 네트워크 정보가 Type - 7의 LSA로 Advertisement 될 수 있도록 하는 구성
        - Area 내부에 ASBR이 있는 경우 Stub Area 혹은 Totally Area로 구성할 수 없으므로 NSSA Stub Area를 구성한다.



### 3. OSPF 분석

- OSPF에서 이웃이 되는 과정
  - OSPF에서 라우터는 주위에 있는 OSPF 라우터들을 찾아서 자신의 데이터베이스 안에 저장하는데, 이런 주위의 라우터들을 Neighbor(이웃)라고 한다.
  - 이러한 이웃을 찾아내기 위해서 OSPF 라우터는 Hello 패킷을 **멀티캐스트**로 보낸다. 이 때, 라우터 ID도 같이 보낸다.
  - Hello 패킷을 받은 다른 라우터들은 Hello 패킷을 송신한 라우터를 자신들의 이웃 리스트에 넣게 되는데 이러한 과정을 **Init** 과정이라 합니다.
  - Hello 패킷을 수신한 OSPF 라우터들이 Hello 패킷을 송신한 라우터에게 **유니캐스트**로 자신들의 중요한 정보를 보내게 된다.
  - 유티캐스트로 메시지를 받은 라우터는 이웃들로 부터 받은 정보를 자신의 이웃 리스트에 넣어 관리한다.
  - 이웃관계를 맺은 라우터끼리 서로 정보를 주고 받아 라우팅 테이블을 업데이트한다.

- OSPF에서 라우팅 테이블을 만들고 유지하는 과정

  - OSPF가 설정된 라우터 간에 Hello 패킷을 주고받아 이웃 및 인접 이웃 관계를 구성한다. 다른 라우팅 프로토콜과는 달리 모든 이웃과 라우팅 정보를 교환하는 것은 아니며, 인접 이웃끼리만 라우팅 정보를 교환한다. 멀티캐스트 주소인 224.0.0.6을 통해 Hello 패킷을 받고 이때 DR과 BDR의 주소를 알게 된다.
  - OSPF에서 라우팅 정보를 Link State Advertisement(LSA)라고 한다. LSA는 라우터의 인터페이스 상태 및 인접 관계를 형성하는 상태에 관한 정보를 포함하며,  네트워크를 통해 전파된다. 각 라우터에서 보낸 LSA의 정보는 라우터의 link state datebase(LSD)를 형성하는데 사용되며, 이 정보로부터 각 목적지까지의 최단 거리를 계산할 수 있다.
    - 자신이 갖고 있는 Link 정보를 LSA에 담아 모든 DR과 BDR에 전송한다.
    - 이 때 사용하는 멀티캐스트 주소는 224.0.0.6이며 이 과정을 Link State Update라고 한다.
    - DR에 LSA가 도착하면 BDR은 자신의 타이머를 가동하고 DR이 이 정보를 다른 OSPF 라우터에게 전달하는 것을 기다린다.
  - 각 라우터들은 전송받은 LSA를 Link State Database(LSD)에 저장한다.
  - LSA 교환이 끝난 후, SPF(shortest Path First) 알고리즘을 사용하여 각 목적지까지의 최적 경로를 계산하고 이를 라우팅 테이블에 다시 저장한다.
    - DR은 이 LSA 정보를 멀티캐스트 주소 224.0.0.5를 이용해서 다른 모든 OSPF 라우터에게 전송한 후 DR이 이 정보를 다른 OSPF 라우터들로부터 Ack을 받아 응답확인한다.
    - 이 때 타이머가 끝날 때까지 DR이 LSA 정보를 다른 라우터에게 전달하지 않는다면 BDR이 DR이 되고 hello 패킷을 이용해서 BDR을 새로 선출하게 된다.
  - 이 후 주기적으로 hello 패킷을 전송하여 각 라우터가 정상적으로 동작하고 있음을 인접 이웃에게 알린다.
    - OSPF 라우터에서 자신이 갖고 있는 링크가 끊어지면 즉시 그 정보를 DR에게 알리고 DR은 그 LSA 정보를 모든 OSPF 라우터에게 멀티캐스트로 전송한다.
  - 만약 네트워크의 상태가 변하게 될 경우, 위의 과정을 반복하여 다시 라우팅 테이블을 만든다.
  - OSPF 라우터가 유지/관리하는 테이블들
    - Neighbor Table : 모든 인접 라우터들의 리스트 관리
    - Link State Database : 소속 망에 대한 토폴로지 관리(LSA로 부터 구축)
    - Routing Table : LSD를 참조 및 이용하여 최적 경로 관리

  

#### 3-1. Wireshark를 이용한 분석

![image-20210409143418452](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409143418452.png)

**OSPF 패킷의 종류**

- Hello
  - OSPF 라우터들이 LSA를 보내기 전에 이웃들을 발견하고 인접을 형성해야만 하므로, 이를 위해 이웃을 형성하고 유지하는데 사용되는 패킷
  
  - 224.0.0.5 멀티캐스트 주소를 사용하여 OSPF가 설정된 인터페이스를 통해 송수신함으로서 인접 라우터와 이웃 관계를 형성한다. 또, 네이버 라우터에게서 일정 시간동안 헬로 패킷을 수신하지 못하면 해당 이웃이 다운된 것으로 간주하여 이웃 관계를 해제한다.
  
  - 패킷 구조
  
    ![image-20210409150540421](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409150540421.png)
  
    - 목적지 주소는 멀티캐스트 주소인 224.0.0.5
    - Version(8bits)
      - 현재는 version 2
    - Type(8bits)
      - 1 : hello
      - 2 : database description
      - 3 : link state request
      - 4 : link state update
      - 5 : link state advertisement
    - Length(16bits)
      - OSPF 헤더를 포함한 전체 길이
    - Source OSPF Router[Router ID] (32bits)
      - OSPF 패킷의 발신지가 되는 라우터를 식별하는 ID
      - 한 AS 내에서의 모든 OSPF 라우터는 32 bit의 유일한 값을 갖도록 함
      - 일반적으로 발신지 라우터 IP 주소를 사용. 라우터 자신의 루프백 주소를 주로 사용하며, 루프백 주소가 가용하지 않을 경우 가용한 다른 인터페이스의 주소 중 가장 높은 것을 사용
    - Area ID(32bits)
      - OSPF 패킷을 생성, 발송하는 라우터가 속한 OSPF Area의 식별 ID
    - Checksum(16bits)
    - Authentication type(16bits)
      - '0' : No Authentication
      - '1' : Simple Password Authentication
      - '2' : MD5
    - Authentication value(64bits)
    - Network Mask
      - interface가 가지고 있는 subnet mask
    - Hello Interval
      - Hello packet을 전송하는 시간 간격을 초 단위로 기입
    - Options
      - 라우터에서 지원되는 옵션을 지정
    - Priority 
      - router의 Priority가 기입되며, 만약 이 기능을 사용하지 않으면 default 1로 설정된다.
    - Dead Interval
      - router의 dead interval(라우터가 죽은 것으로 선언하기까지의 시간)를 기록한다.
      - 해당 라우터로부터 hello 패킷을 받는 즉시 리셋 됨
    - Designated Router
      - Network 상의 DR의 IP address가 기록된다.
    - Backup Designated Router
      - Network 상의 BDR의 IP address가 포함된다.
    - Neighbor
      - Valid hello packet을 보낸 각 Router의 Router ID를 포함한다.
- Database Description Packet(DBD /DDP)
  
  - OSPF의 네트워크 정보를 Link State Advertisement(LSA)라고 부르는데, 자신이 만든 LSA 및 네이버에게서 수신한 LSA를 모두 Link state database에 저장한다. DDP는 OSPF 이웃 라우터간에 LSA들을 교환하기 전에 자신의 Link state database에 있는 LSA 목록을 상대 라우터에게 알려주기 위해 사용한다.
  
  - 패킷 구조
  
    ![image-20210412085010183](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210412085010183.png)
  
    
- Link State Request(LSR)
  
  - 상대 라우터가 보낸 DDP를 보고 자신에게 없는 네트워크 정보(LSA)가 있으면 상세한 내용(LSA)을 요청할 때 사용한다.
  
  - 패킷 구조
  
    ![image-20210412085057205](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210412085057205.png)
  
    
- Link State Update(LSU)
  
  - 상대 라우터에게서 LSR을 받거나 네트워크 상태가 변했을 경우 해당 라우팅 정보를 전송할 때 사용하는 패킷이다. 즉, LSU는 LSA를 실어나를 때 사용하는 패킷이다.
  
  - 패킷 구조
  
    ![image-20210412085400636](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210412085400636.png)
  
    
- Link State Acknowledgement(LSAck)
  
  - OSPF 패킷을 정상적으로 수신했음을 알려줄 때 사용된다. OSPF는 DDP, LSR 및 LSU 패킷을 수신하면 반드시 LSAck 패킷을 사용하여 상대에게 정상적으로 수신했음을 알려야 한다.
  
  - 패킷 구조
  
    ![image-20210412085511867](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210412085511867.png)
  
    

#### 'show ip protocol' 명령어를 통한 분석

![image-20210409172901777](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409172901777.png)

- Stub Area
  - OSPF 경로 코드의 O IA까지만 허용하며, O E1, O E2는 차단한다.
  - 외부 네트워크에 대한 LSA 정보가 없기 때문에 경로 선출이 불가능하므로 ABR이 기본 경로를 대신 알려준다.
- NSSA
  - Stub Area에 ASBR을 포함하여 구성하는 방식
  - 외부 네트워크에 대한 Type - 5의 LSA가 내부 라우터로 Advertisement 되지 않으므로 Area 내부에 ASBR 이 있을 경우 외부 네트워크 정보가 Type - 7의 LSA로 Advertisement 될 수 있도록 하는 구성
  - Area 내부에 ASBR이 있는 경우 Stub Area 혹은 Totally Area로 구성할 수 없으므로 NSSA Stub Area를 구성한다.



#### 'show ip ospf neighbor' 명령어를 통한 분석

![image-20210409173719877](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409173719877.png)



#### 'show ip ospf database' 명령어를 통한 분석

![image-20210411223105305](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411223105305.png)

![image-20210411222932527](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411222932527.png)



#### 'show ip route x.x.x.x' 명령어를 통한 분석

![image-20210409174143980](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409174143980.png)

- Cost[Metric] 계산은 수신 되는 쪽이 기준!

  12 = 8의 루프백 + 8의 루프백에서 172.48.0.1 + 172.48.0.1에서 172.14.0.1

- Cost = 10^8 / 각 구간 인터페이스 실제 대역폭

  ![image-20210411222744601](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210411222744601.png)



#### 'show ip ospf interface brief' 명령어를 통한 분석

![image-20210409174209796](C:\Users\10152071\AppData\Roaming\Typora\typora-user-images\image-20210409174209796.png)









