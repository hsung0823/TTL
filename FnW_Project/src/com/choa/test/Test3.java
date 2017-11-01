package com.choa.test;

import java.sql.Date;
import java.util.StringTokenizer;

import com.fnw.book.Book_TotalDAO;
import com.fnw.book.Book_TotalDTO;
 
public class Test3 {
 
    public static void main(String[] args) {
         
         Book_TotalDTO book_TotalDTO = new Book_TotalDTO();
   
        String txt = "1	~~	(실력이 탐나는)포토샵 일러스트레이터 CS6	~~	유진영	~~	정보문화사	~~	17/10/06	~~	a.001	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"2	~~	(이주영 선생님의)책으로 행복한 교실 이야기	~~	이주영	~~	행복한아침독서	~~	2014	~~	a.002	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"3	~~	SketchBook Pro: 디지털 스케치 쉽게하기	~~	노영주	~~	정보문화사	~~	2014	~~	a.003	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"4	~~	낭독은 입문학이다	~~	김보경	~~	현자의마을	~~	2014	~~	a.004	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"5	~~	느리게 읽기	~~	데이비드 미킥스	~~	위즈덤하우스	~~	2014	~~	a.005	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"6	~~	답답해서 내가 쓴 지식사전 :  지리편	~~	하누리	~~	제이그룹	~~	2014	~~	a.006	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"7	~~	대통령의 글쓰기	~~	강원국	~~	메디치미디어	~~	2014	~~	a.007	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"8	~~	대한민국 소프트웨어 성공 방정식	~~	김재호	~~	제이펍	~~	2014	~~	a.008	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"9	~~	마음 독서	~~	장길섭	~~	나마스테	~~	2014	~~	a.009	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"10	~~	스타트업 똑똑하게 시작하라	~~	최환진	~~	지앤선	~~	2014	~~	a.010	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"11	~~	왜 책을 만드는가	~~	맥스위니스 편집부 (엮음)	~~	미메시스	~~	2014	~~	a.011	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"12	~~	월스트리트저널 인포그래픽 가이드	~~	도나 M. 웡	~~	인사이트	~~	2014	~~	a.012	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"13	~~	자바를 다루는 기술	~~	김병부	~~	길벗	~~	2014	~~	a.013	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"14	~~	좋아 보이는 것들의 비밀 인포그래픽	~~	김묘영	~~	길벗	~~	2014	~~	a.014	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"15	~~	토론하는 호모루덴스	~~	강경순	~~	교육과학사	~~	2014	~~	a.015	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"16	~~	폴리글랏 프로그래밍	~~	임백준	~~	한빛미디어	~~	2014	~~	a.016	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"17	~~	한국의 출판기획자	~~	기획회의 편집위원회	~~	한국출판마케팅연구소	~~	2014	~~	a.017	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"18	~~	(생각하는 십대를 위한)고전 콘서트	~~	강신주	~~	꿈결	~~	2014	~~	b.001	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"19	~~	(정신과 의사가 들려주는)마음의 병 23가지	~~	보르빈 반델로	~~	교양인	~~	2014	~~	b.002	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"20	~~	365일 동양 최고의 지혜 채근담	~~	홍자성	~~	인문학서재	~~	2014	~~	b.003	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"21	~~	결의론의 남용 :  도덕 추론의 역사	~~	앨버트 존슨	~~	로도스	~~	2014	~~	b.004	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"22	~~	길 위의 철학자	~~	에릭 호퍼	~~	이다미디어	~~	2014	~~	b.005	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"23	~~	단테	~~	에리히 아우어바흐	~~	연암서가	~~	2014	~~	b.006	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"24	~~	딥씽킹	~~	성열홍	~~	21세기북스	~~	2014	~~	b.007	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"25	~~	또 다른 나 친구	~~	앤서니 그레일링	~~	중앙북스	~~	2014	~~	b.008	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"26	~~	로스트 제너레이션 심리학	~~	구마시로 도루	~~	클	~~	2014	~~	b.009	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"27	~~	마르크스 씨 어떻게 행복해질 수 있죠	~~	이남석	~~	탐	~~	2014	~~	b.010	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"28	~~	만들어진 생각 만들어진 행동	~~	애덤 알터	~~	알키	~~	2014	~~	b.011	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"29	~~	모멸감	~~	김찬호	~~	문학과지성사	~~	2014	~~	b.012	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"30	~~	별자리 서당	~~	손영달	~~	북드라망	~~	2014	~~	b.013	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"31	~~	불안이 주는 지혜	~~	앨런 와츠	~~	마디	~~	2014	~~	b.014	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"32	~~	사랑의 역사	~~	남미영	~~	김영사	~~	2014	~~	b.015	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"33	~~	사물의 표시: 방법에 관하여	~~	조르조 아감벤	~~	난장	~~	2014	~~	b.016	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"34	~~	삶의 과학	~~	알프레드 아들러	~~	부글북스	~~	2014	~~	b.017	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"35	~~	생각의 한계	~~	로버트 버튼	~~	더좋은책	~~	2014	~~	b.018	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"36	~~	선택 선택의 재발견	~~	김운하	~~	은행나무	~~	2014	~~	b.019	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"37	~~	설득의 정석	~~	황현진	~~	비즈니스북스	~~	2014	~~	b.020	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"38	~~	숨겨진 지식	~~	신종원	~~	컬처스토리	~~	2014	~~	b.021	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"39	~~	신학자가 풀어 쓴 유교 이야기	~~	배요한	~~	IVP	~~	2014	~~	b.022	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"40	~~	앨리스처럼 철학하기	~~	메간 S. 로이드	~~	인벤션	~~	2014	~~	b.023	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"41	~~	양심을 보았다	~~	이얼 프레스	~~	흐름출판	~~	2014	~~	b.024	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"42	~~	언더그라운드 니체	~~	고병권	~~	천년의상상	~~	2014	~~	b.025	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"43	~~	영혼의 연금술	~~	에릭 호퍼	~~	이다미디어	~~	2014	~~	b.026	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"44	~~	영화로 읽는 서양 철학사	~~	이창후	~~	새문사	~~	2014	~~	b.027	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"45	~~	운이 좋아지는 사주공부	~~	엄나연	~~	스위치북	~~	2014	~~	b.028	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"46	~~	의료윤리의 역사	~~	앨버트 존슨	~~	로도스	~~	2014	~~	b.029	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"47	~~	이렇게 살아가도 괜찮은가	~~	피터 싱어	~~	시대의창	~~	2014	~~	b.030	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"48	~~	인간의 조건	~~	에릭 호퍼	~~	이다미디어	~~	2014	~~	b.031	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"49	~~	자율성과 공동체주의	~~	앤 돈친	~~	로도스	~~	2014	~~	b.032	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"50	~~	저는 인문학이 처음인데요	~~	박홍순	~~	한빛비즈	~~	2014	~~	b.033	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"51	~~	좋은 유럽인 니체	~~	데이비드 패럴 크렐	~~	글항아리	~~	2014	~~	b.034	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"52	~~	지식애	~~	로이 브랜드	~~	책읽는수요일	~~	2014	~~	b.035	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"53	~~	칭찬과 꾸중의 심리학	~~	오쿠다 켄지	~~	센추리원	~~	2014	~~	b.036	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"54	~~	투명사회	~~	한병철	~~	문학과지성사	~~	2014	~~	b.037	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"55	~~	행복한 사람들은 무엇이 다른가	~~	조르디 쿠아드박	~~	북로드	~~	2014	~~	b.038	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"56	~~	현대 생명윤리의 쟁점들	~~	이화여자대학교 생명의료법연구소	~~	로도스	~~	2014	~~	b.039	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"57	~~	황금꽃의 비밀	~~	카를 구스타프 융	~~	문학동네	~~	2014	~~	b.040	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"58	~~	효율성 문명의 편견	~~	이근세	~~	은행나무	~~	2014	~~	b.041	~~	  1 	~~	철학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"59	~~	21세기 신앙인에게	~~	유경촌	~~	가톨릭출판사	~~	2014	~~	c.001	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"60	~~	Why Jesus	~~	조정민	~~	두란노서원	~~	2014	~~	c.002	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"61	~~	고백	~~	이재록	~~	우림	~~	2014	~~	c.003	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"62	~~	공부는 예배다(개정판)	~~	박철범	~~	다산북스	~~	2014	~~	c.004	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"63	~~	구름기둥	~~	김영애	~~	두란노서원	~~	2014	~~	c.005	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"64	~~	기도 도량을 찾아서	~~	황찬익	~~	클리어마인드	~~	2014	~~	c.006	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"65	~~	나이 드는 내가 좋다	~~	요한 크리스토프 아놀드	~~	포이에마	~~	2014	~~	c.007	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"66	~~	돌봄의 영성	~~	헨리 나우웬	~~	두란노서원	~~	2014	~~	c.008	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"67	~~	사랑의 메신저. 1 :  하나님의 사랑 하나님의 위로	~~	김하중	~~	두란노	~~	2014	~~	c.009	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"68	~~	서른통	~~	김남준	~~	생명의말씀사	~~	2014	~~	c.010	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"69	~~	성 프란치스코의 생애	~~	헤르만 헤세	~~	프란치스코출판사	~~	2014	~~	c.011	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"70	~~	어느 불교무신론자의 고백	~~	스티븐 배철러	~~	궁리	~~	2014	~~	c.012	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"71	~~	존 비비어의 성령님	~~	존 비비어	~~	두란노	~~	2014	~~	c.013	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"72	~~	천하무적 아르뱅주의	~~	신광은	~~	포이에마	~~	2014	~~	c.014	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"73	~~	한국신화의 재발견	~~	권태효	~~	새문사	~~	2014	~~	c.015	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"74	~~	행동하는 예수	~~	김근수	~~	메디치미디어	~~	2014	~~	c.016	~~	  1 	~~	종교	~~	0	~~	0	~~	0	@@\r\n" + 
        		"75	~~	(구글 에버노트 소셜미디어를 활용한)프로세일즈맨의 스마트워크	~~	한가늠	~~	새로운제안	~~	2014	~~	d.001	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"76	~~	(국내 최초의 보이스코치 임유정의)목소리 트레이닝북	~~	임유정	~~	원앤원북스	~~	2014	~~	d.002	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"77	~~	(내 아들에게 꼭 전해주고 싶은)아버지의 커리어 다이어리	~~	한준기	~~	책보세	~~	2014	~~	d.003	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"78	~~	(모든 아이들의 꿈을 키우는)행복한 창의 교육	~~	최창의	~~	살림터	~~	2014	~~	d.004	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"79	~~	(사람을 얻기 위해서는)따뜻하게 말하라	~~	정영순	~~	파트너북스	~~	2014	~~	d.005	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"80	~~	(인사팀 이부장이 알려주는)위풍당당 회사생활 가이드	~~	이호석	~~	길벗	~~	2014	~~	d.006	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"81	~~	(화내거나 큰소리 내지 않고)이기는 말의 기술	~~	최찬훈	~~	추수밭	~~	2014	~~	d.007	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"82	~~	100세 시대 은퇴 대사전	~~	송양민	~~	21세기북스	~~	2014	~~	d.008	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"83	~~	800년 장사의 비밀	~~	서유진	~~	틔움	~~	2014	~~	d.009	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"84	~~	88연승의 비밀	~~	존 우든	~~	클라우드나인	~~	2014	~~	d.010	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"85	~~	CEO의 독서경영	~~	다이애나 홍	~~	일상이상	~~	2014	~~	d.011	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"86	~~	E2 :  소원을 이루는 마력	~~	팸 그라우트	~~	알키	~~	2014	~~	d.012	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"87	~~	I Have a Dream	~~	아서 플라워스	~~	푸른지식	~~	2014	~~	d.013	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"88	~~	가계부 쓰지 마라	~~	최영균	~~	모멘텀	~~	2014	~~	d.014	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"89	~~	가난한 싱글을 위한 나라는 없다	~~	이지영	~~	토네이도	~~	2014	~~	d.015	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"90	~~	감성의 끝에 서라	~~	강신장, 황인원	~~	21세기북스	~~	2014	~~	d.016	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"91	~~	경제기사가 말해주지 않는 28가지	~~	윤석천	~~	왕의서재	~~	2014	~~	d.017	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"92	~~	고전으로 읽는 자본주의	~~	조준현	~~	다시봄	~~	2014	~~	d.018	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"93	~~	공모전 무작정따라하기	~~	이혁진	~~	길벗	~~	2014	~~	d.019	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"94	~~	공부란 무엇인가	~~	이원석	~~	책담	~~	2014	~~	d.020	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"95	~~	긍정적인 사람의 힘	~~	시모다이라 구미코	~~	토네이도	~~	2014	~~	d.021	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"96	~~	나는 셰어하우스에 산다	~~	니시카와 아쓰코	~~	푸른지식	~~	2014	~~	d.022	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"97	~~	나를 지켜낸다는 것	~~	팡차오후이	~~	위즈덤하우스	~~	2014	~~	d.023	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"98	~~	나무에 돈이 열린다면	~~	데이비드 보일	~~	황소걸음	~~	2014	~~	d.024	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"99	~~	남편보다 월세통장이 더 좋아	~~	김종선	~~	비전코리아	~~	2014	~~	d.025	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"100	~~	넥스트 리더십	~~	김택환	~~	메디치미디어	~~	2014	~~	d.026	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"101	~~	농업의 대반격	~~	김재수	~~	프리뷰	~~	2014	~~	d.027	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"102	~~	느리게 더 느리게	~~	장샤오헝	~~	다연	~~	2014	~~	d.028	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"103	~~	다시 분노하라	~~	김상구	~~	책과나무	~~	2014	~~	d.029	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"104	~~	단속사회	~~	엄기호	~~	창비	~~	2014	~~	d.030	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"105	~~	대한민국에서 일하는 엄마로 산다는 것	~~	신의진	~~	걷는나무	~~	2014	~~	d.031	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"106	~~	독일리포트 :  미래 한국의 패러다임을 찾아	~~	국민일보 특별취재팀	~~	이지북	~~	2014	~~	d.032	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"107	~~	돈이 모이는 생활의 법칙	~~	짠돌이카페 슈퍼짠 9인	~~	길벗	~~	2014	~~	d.033	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"108	~~	동물들의 침묵	~~	존 그레이	~~	이후	~~	2014	~~	d.034	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"109	~~	디스턴스	~~	이동우	~~	엘도라도	~~	2014	~~	d.035	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"110	~~	마음을 사로잡는 인간경영	~~	월터 딜 스콧	~~	돋을새김	~~	2014	~~	d.036	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"111	~~	멋쟁이 남자들의 이야기 댄디즘	~~	쥘 바르베 도르비이	~~	이봄	~~	2014	~~	d.037	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"112	~~	모험 본능을 깨워라	~~	스킵 요웰	~~	푸르메	~~	2014	~~	d.038	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"113	~~	무엇을 할 것인가	~~	손석춘	~~	시대의창	~~	2014	~~	d.039	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"114	~~	뭐라도 합시다	~~	이철희	~~	알에이치코리아	~~	2014	~~	d.040	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"115	~~	미래학자의 통찰법	~~	최윤식	~~	김영사	~~	2014	~~	d.041	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"116	~~	백만 개의 조용한 혁명	~~	베네딕트 마니에	~~	책세상	~~	2014	~~	d.042	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"117	~~	변호사처럼 반론하라	~~	우에노 마사루	~~	끌리는책	~~	2014	~~	d.043	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"118	~~	부실조직에서 명품조직으로	~~	전병호	~~	청년정신	~~	2014	~~	d.044	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"119	~~	브레인 트러스트	~~	가스 선뎀	~~	진성북스	~~	2014	~~	d.045	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"120	~~	사다리 정치	~~	정진석	~~	웅진윙스	~~	2014	~~	d.046	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"121	~~	사람들 앞에 서면 나는 왜 작아질까	~~	크리스토프 앙드레	~~	민음인	~~	2014	~~	d.047	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"122	~~	서울 아케이드 프로젝트	~~	류신	~~	민음사	~~	2013	~~	d.048	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"123	~~	선생님은 살아 있는 교육과정이다	~~	김용근	~~	물병자리	~~	2014	~~	d.049	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"124	~~	세계로TV의 신가치투자로 돈 번 사람들	~~	김원기	~~	글로벌북스	~~	2014	~~	d.050	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"125	~~	셀프 파워	~~	김종식	~~	오우아	~~	2014	~~	d.051	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"126	~~	소셜픽션 지금 세계는 무엇을 상상하고 있는가	~~	이원재	~~	어크로스	~~	2014	~~	d.052	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"127	~~	소평 소도	~~	김상문	~~	아이케이	~~	2014	~~	d.053	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"128	~~	손맛으로 보는 한국인의 문화	~~	정수현	~~	삼인	~~	2014	~~	d.054	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"129	~~	슈퍼커넥터	~~	마크 W. 셰퍼	~~	라이온북스	~~	2014	~~	d.055	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"130	~~	스냅	~~	매튜 헤르텐슈타인	~~	비즈니스북스	~~	2014	~~	d.056	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"131	~~	스노든의 위험한 폭로	~~	루크 하딩	~~	프롬북스	~~	2014	~~	d.057	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"132	~~	승풍파랑	~~	가오위엔	~~	북로그컴퍼니	~~	2014	~~	d.058	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"133	~~	시인의 교실	~~	조향미	~~	교육공동체벗	~~	2014	~~	d.059	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"134	~~	쓰레기 문명의 그림자	~~	카트린 드 실기	~~	따비	~~	2014	~~	d.060	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"135	~~	약자를 위한 경제학	~~	이정우	~~	개마고원	~~	2014	~~	d.061	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"136	~~	어른의 공식	~~	장옌	~~	불광출판사	~~	2014	~~	d.062	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"137	~~	어포메이션	~~	노아 세인트 존	~~	이책	~~	2014	~~	d.063	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"138	~~	오가닉 미디어	~~	윤지영	~~	21세기북스	~~	2014	~~	d.064	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"139	~~	오늘이 내인생의 마지막 날이라면	~~	KBS 생로병사의 비밀 제작팀	~~	애플북스	~~	2014	~~	d.065	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"140	~~	왜 유대인인가	~~	마빈 토케이어	~~	스카이	~~	2014	~~	d.066	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"141	~~	우리는 가족 일까	~~	몸문화연구소	~~	은행나무	~~	2014	~~	d.067	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"142	~~	우리는 모두 집을 떠난다	~~	김현미	~~	돌베개	~~	2014	~~	d.068	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"143	~~	우리도 몰랐던 우리 문화	~~	강준만	~~	인물과사상사	~~	2014	~~	d.069	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"144	~~	유혹하는 플라스틱	~~	로리 에시그	~~	이른아침	~~	2014	~~	d.070	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"145	~~	이 선생의 학교폭력 상담실	~~	따돌림사회연구모임 (기획)	~~	양철북	~~	2014	~~	d.071	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"146	~~	인생의 내공을 어떻게 키울 것인가	~~	김승중	~~	물푸레	~~	2014	~~	d.072	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"147	~~	인생이란 나를 믿고 가는 것이다	~~	이현세	~~	토네이도	~~	2014	~~	d.073	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"148	~~	일베의 사상	~~	박가분	~~	오월의봄	~~	2013	~~	d.074	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"149	~~	자신을 브랜딩하는 방법	~~	CA 편집부	~~	퓨처미디어	~~	2014	~~	d.075	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"150	~~	정의의 적들	~~	표창원	~~	한겨레출판사	~~	2014	~~	d.076	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"151	~~	제3의 성공	~~	아리아니 허핑턴	~~	김영사	~~	2014	~~	d.077	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"152	~~	존 F. 케네디의 위대한 협상	~~	제프리 D. 삭스	~~	21세기북스	~~	2014	~~	d.078	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"153	~~	죽은 자의 정치학	~~	하상복	~~	모티브북	~~	2014	~~	d.079	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"154	~~	지금 중국 주식 천만원이면 10년 후 강남 아파트를 산다	~~	정순필	~~	스마트비즈니스	~~	2014	~~	d.080	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"155	~~	직장 생존 병법 41가지	~~	박세준	~~	평단문화사	~~	2014	~~	d.081	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"156	~~	진심진력 :  삶의 전장에서 이순신을 만나다	~~	박종평	~~	길벗	~~	2014	~~	d.082	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"157	~~	차이나 핸드북	~~	성균중국연구소	~~	김영사	~~	2014	~~	d.083	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"158	~~	처음 20시간의 법칙	~~	조시 카우프만	~~	알키	~~	2014	~~	d.084	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"159	~~	철도의 눈물	~~	박흥수	~~	후마니타스	~~	2013	~~	d.085	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"160	~~	친애하는 빅브라더	~~	지그문트 바우만	~~	오월의봄	~~	2014	~~	d.086	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"161	~~	케인스 하이에크	~~	니컬러스 웝숏	~~	부키	~~	2014	~~	d.087	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"162	~~	케인스 혁명 다시 읽기	~~	하이먼 민스키	~~	후마니타스	~~	2014	~~	d.088	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"163	~~	포커스	~~	대니얼 골먼	~~	리더스북	~~	2014	~~	d.089	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"164	~~	하버드의 생각수업	~~	후쿠하라 마사히로	~~	엔트리	~~	2014	~~	d.090	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"165	~~	행복의 사회학	~~	정태석	~~	책읽는수요일	~~	2014	~~	d.091	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"166	~~	행복하려면 녹색	~~	하승수	~~	이매진	~~	2014	~~	d.092	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"167	~~	현대 중국 지식인 지도	~~	조경란	~~	글항아리	~~	2013	~~	d.093	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"168	~~	혼신의 힘	~~	최석영	~~	인물과사상사	~~	2014	~~	d.094	~~	  1 	~~	사회과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"169	~~	(쉽게 배우는)기본 물리학	~~	유주식	~~	교육과학사	~~	2014	~~	e.001	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"170	~~	고급 생명과학 실험	~~	김상우	~~	부산대학교출판부	~~	2014	~~	e.002	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"171	~~	금성에서 온 여인	~~	옴넥 오넥	~~	은하문명	~~	2014	~~	e.003	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"172	~~	꿈꾸는 산막	~~	최호경	~~	지식과감성	~~	2014	~~	e.004	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"173	~~	당신에게 노벨상을 수여합니다: 노벨 물리학상	~~	노벨 재단	~~	바다출판사	~~	2014	~~	e.005	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"174	~~	당신에게 노벨상을 수여합니다: 노벨 생리 의학상	~~	노벨 재단	~~	바다출판사	~~	2014	~~	e.006	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"175	~~	당신에게 노벨상을 수여합니다: 노벨 화학상	~~	노벨 재단	~~	바다출판사	~~	2014	~~	e.007	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"176	~~	대구	~~	마크 쿨란스키	~~	알에이치코리아	~~	2014	~~	e.008	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"177	~~	동물번식생리 이해와 응용	~~	김옥진	~~	동일출판사	~~	2014	~~	e.009	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"178	~~	미지에서 묻고 경계에서 답하다	~~	고산	~~	사이언스북스	~~	2013	~~	e.010	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"179	~~	바람을 먹고 이슬에 잠자다	~~	이종렬	~~	FIELD GUIDE	~~	2014	~~	e.011	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"180	~~	사람과 더불어 사는 우리 고장의 명목	~~	조병진	~~	씨앗북스	~~	2014	~~	e.012	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"181	~~	산과 들에 있는 약초	~~	최수찬	~~	지식서관	~~	2014	~~	e.013	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"182	~~	수학입문	~~	김준교	~~	부산대학교출판부	~~	2014	~~	e.014	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"183	~~	암흑물질	~~	Ken Freeman	~~	청범출판사	~~	2014	~~	e.015	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"184	~~	우리 혜성 이야기	~~	안상현	~~	사이언스북스	~~	2013	~~	e.016	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"185	~~	윈드프로파일러와 대기탐측	~~	허복행	~~	홍릉과학출판사	~~	2014	~~	e.017	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"186	~~	유용곤충 길라잡이	~~	김옥진	~~	동일출판사	~~	2014	~~	e.018	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"187	~~	죽설헌 원림	~~	박태후	~~	열화당	~~	2014	~~	e.019	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"188	~~	지구물리탐사 개론	~~	Alan E. Mussett	~~	시그마프레스	~~	2014	~~	e.020	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"189	~~	지속가능한 연안개발(2판)	~~	박우선	~~	한국해양과학기술원	~~	2014	~~	e.021	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"190	~~	프로그래머 수학으로 생각하라	~~	유키 히로시	~~	프리렉	~~	2014	~~	e.022	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"191	~~	하룻밤에 읽는 과학사(개정판)	~~	하시모토 히로시	~~	알에이치코리아	~~	2014	~~	e.023	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"192	~~	해양과 문화	~~	김성준	~~	문현	~~	2014	~~	e.024	~~	  1 	~~	자연과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"193	~~	(건강을 위한)기초영양	~~	장유경	~~	형설출판사	~~	2014	~~	f.001	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"194	~~	(기계공학도를 위한)열유체공학실험	~~	정진은	~~	지필미디어	~~	2014	~~	f.002	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"195	~~	(김민지 셰프의)사계절 한식 코스요리	~~	김민지	~~	조선앤북	~~	2014	~~	f.003	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"196	~~	(매일매일 내 아이를 빛나게 하는)여자아이 헤어스타일	~~	코지 프리드먼	~~	터닝포인트	~~	2014	~~	f.004	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"197	~~	(아이의 학습과 인성을 결정하는)초등 6년 공부머리 만들기	~~	곽윤정	~~	지식채널	~~	2014	~~	f.005	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"198	~~	(요리가 간편해지는)만능양념장 레시피	~~	이현주	~~	경향미디어	~~	2014	~~	f.006	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"199	~~	(치매 예방과 젊은 뇌를 위한)기적의 뇌건강 운동법	~~	한국뇌과학연구원	~~	비타북스	~~	2014	~~	f.007	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@\r\n" + 
        		"200	~~	1일 2분 스트레칭	~~	닛케이BP사 헬스 편집부	~~	로그인	~~	2014	~~	f.008	~~	  1 	~~	기술과학	~~	0	~~	0	~~	0	@@";
         
        
         
        // split을 이용한 문자열 분리
        String[] txtArr1 = txt.split("@@");
        for(int i=0; i<txtArr1.length; i++)  {
       
        	for(int j=0; j<11; j++){
        		String[] txtArr2 = txtArr1[i].split("~~"); //한줄을 ~~로 파싱
        		
        		/*System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;*/
        		book_TotalDTO.setNum(Integer.parseInt(txtArr2[j].trim()));
        		j++;
            	book_TotalDTO.setTitle(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setWriter(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setCompany(txtArr2[j].trim());
            	j++;
            	System.out.println("d");
            	System.out.println(book_TotalDTO.getCompany());
            	/*book_TotalDTO.setPublish_date(Date.valueOf(txtArr2[j].trim()));*/
            	System.out.println("d");
            	j++;
            	book_TotalDTO.setSection(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setLibrary(Integer.parseInt(txtArr2[j].trim()));
            	j++;
            	book_TotalDTO.setType(Integer.parseInt(txtArr2[j].trim()));
            	j++;
            	book_TotalDTO.setState(Integer.parseInt(txtArr2[j].trim()));
            	j++;
            	book_TotalDTO.setRent_id(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setRent_count(Integer.parseInt(txtArr2[j].trim()));
            	j++;
        		
        		//System.out.println(txtArr2[j].trim());
        		
        		//book_TotalDTO.setNum(Integer.parseInt(txtArr2[j].trim()));
        		/*book_TotalDTO.setTitle(txtArr2[j+1].trim());*/
        		
        	/*	book_TotalDTO.setNum(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setTitle(txtArr2[j].trim());
            	book_TotalDTO.setWriter(txtArr2[j].trim());
            	book_TotalDTO.setCompany(txtArr2[j].trim());
            	book_TotalDTO.setPublish_date(Date.valueOf(txtArr2[j].trim()));
            	book_TotalDTO.setSection(txtArr2[j].trim());
            	book_TotalDTO.setLibrary(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setType(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setState(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setRent_id(txtArr2[j].trim());
            	book_TotalDTO.setRent_count(Integer.parseInt(txtArr2[j].trim()));*/
        		
        		
        		/*Book_TotalDAO book_TotalDAO = new Book_TotalDAO();
        		try {
					book_TotalDAO.insert2(book_TotalDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		j+=10;*/
        		
        	}//for
        	
        	System.out.println("=========");
        }//for
        
     
   
    }
}


