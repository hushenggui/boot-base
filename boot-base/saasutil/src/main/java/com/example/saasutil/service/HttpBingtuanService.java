package com.example.saasutil.service;

import com.example.saasutil.util.JacksonUtils;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-04-18 17:16
 **/
public class HttpBingtuanService {

  public static void main(String[] args) {
    String ids = "10110106501002023082217245898912\n"
        + "10110106501002023082211492580505\n"
        + "10110106501002023082211444663639\n"
        + "10110106501002023082211343595155\n"
        + "10110106501002023082211083082952\n"
        + "10110106501002023082210324457005\n"
        + "10110106501002023082118254348689\n"
        + "1011010650100202308211748126352\n"
        + "10110106501002023082117455177750\n"
        + "10110106501002023082116435984630\n"
        + "10110106501002023082116130252502\n"
        + "1011010650100202308211527093439\n"
        + "10110106501002023082112390758587\n"
        + "10110106501002023082112275657284\n"
        + "10110106501002023082111324766288\n"
        + "10110106501002023082111212050076\n"
        + "10110106501002023082111081723041\n"
        + "10110106501002023082111074638838\n"
        + "10110106501002023082110542584672\n"
        + "10110106501002023082110540567692\n"
        + "10110106501002023082110530511702\n"
        + "10110106501002023082110505647601\n"
        + "10110106501002023082110504356171\n"
        + "10110106501002023082110292647241\n"
        + "1011010650100202308211008202992\n"
        + "10110106501002023082110034631325\n"
        + "1011010650100202308210958353934\n"
        + "10110106501002023082109553249085\n"
        + "10110106501002023082109515723876\n"
        + "1011010650100202308210933289030\n"
        + "10110106501002023082109243527425\n"
        + "10110106501002023082109193947550\n"
        + "10110106501002023082109060746557\n"
        + "10110106501002023082108510735951\n"
        + "10110106501002023082020124387617\n"
        + "10110106501002023082009430768362\n"
        + "10110106501002023082009362684346\n"
        + "10110106501002023081918420377589\n"
        + "10110106501002023081916282963032\n"
        + "10110106501002023081914440896814\n"
        + "10110106501002023081912312810603\n"
        + "10110106501002023081912065382034\n"
        + "10110106501002023081818073965419\n"
        + "10110106501002023081818023752486\n"
        + "10110106501002023081816304483055\n"
        + "10110106501002023081816065968706\n"
        + "10110106501002023081813270211546\n"
        + "10110106501002023081813244099232\n"
        + "1011010650100202308181223449612\n"
        + "10110106501002023081811301923050\n"
        + "10110106501002023081811052515114\n"
        + "10110106501002023081811014377935\n"
        + "10110106501002023081810585654456\n"
        + "10110106501002023081810332891335\n"
        + "10110106501002023081810273999678\n"
        + "10110106501002023081810214628373\n"
        + "1011010650100202308171823527437\n"
        + "10110106501002023081718192817908\n"
        + "10110106501002023081718045311491\n"
        + "10110106501002023081717314069450\n"
        + "10110106501002023081716323199167\n"
        + "10110106501002023081716280271897\n"
        + "10110106501002023081716271855806\n"
        + "10110106501002023081715392169519\n"
        + "10110106501002023081714343153387\n"
        + "10110106501002023081713281871558\n"
        + "10110106501002023081712113987483\n"
        + "10110106501002023081712060496931\n"
        + "10110106501002023081712050217744\n"
        + "10110106501002023081711365685840\n"
        + "10110106501002023081711083723155\n"
        + "10110106501002023081711051829895\n"
        + "10110106501002023081617561797487\n"
        + "10110106501002023081616102612557\n"
        + "10110106501002023081609453629514\n"
        + "10110106501002023081609421159828\n"
        + "1011010650100202308151815369229\n"
        + "10110106501002023081517342146657\n"
        + "10110106501002023081517095898307\n"
        + "10110106501002023081516151059904\n"
        + "10110106501002023081514342156288\n"
        + "10110106501002023081512495323643\n"
        + "10110106501002023081512243717722\n"
        + "10110106501002023081512222331774\n"
        + "1011010650100202308151209524175\n"
        + "10110106501002023081511452766135\n"
        + "10110106501002023081416580544694\n"
        + "1011010650100202308141630259412\n"
        + "10110106501002023081415050512047\n"
        + "1011010650100202308141501595769\n"
        + "10110106501002023081413074930300\n"
        + "10110106501002023081412181352171\n"
        + "10110106501002023081411403784440\n"
        + "10110106501002023081411292857599\n"
        + "10110106501002023081409441056972\n"
        + "10110106501002023081316463196303\n"
        + "10110106501002023081316323511023\n"
        + "10110106501002023081315584054630\n"
        + "1011010650100202308120208442900\n"
        + "10110106501002023081116034251161\n"
        + "10110106501002023081114285956456\n"
        + "10110106501002023081112502184666\n"
        + "10110106501002023081112475374164\n"
        + "10110106501002023081111152720079\n"
        + "10110106501002023081110442156268\n"
        + "10110106501002023081110325151589\n"
        + "10110106501002023081019171219471\n"
        + "1011010650100202308101836143178\n"
        + "10110106501002023081015225367897\n"
        + "10110106501002023081014281312141\n"
        + "10110106501002023081011175789843\n"
        + "10110106501002023081010045315469\n"
        + "10110106501002023080918131329609\n"
        + "10110106501002023080917571429255\n"
        + "10110106501002023080916305178065\n"
        + "10110106501002023080912011692587\n"
        + "1011010650100202308082002321084\n"
        + "10110106501002023080816322760978\n"
        + "10110106501002023080815122220815\n"
        + "10110106501002023080813520270839\n"
        + "10110106501002023080813372299929\n"
        + "1011010650100202308081333225106\n"
        + "10110106501002023080812261563598\n"
        + "10110106501002023080810242148949\n"
        + "1011010650100202308081004027197\n"
        + "10110106501002023080810030772810\n"
        + "10110106501002023080719261391209\n"
        + "10110106501002023080719093349279\n"
        + "10110106501002023080717415565743\n"
        + "10110106501002023080716155783396\n"
        + "10110106501002023080712411964175\n"
        + "10110106501002023080712303892033\n"
        + "10110106501002023080710344476396\n"
        + "10110106501002023080710254670618\n"
        + "10110106501002023080611351574295\n"
        + "10110106501002023080411255922212\n"
        + "10110106501002023080411244976424\n"
        + "10110106501002023080410370087088\n"
        + "101101065010020230803122920678\n"
        + "10110106501002023080219075248516\n"
        + "1011010650100202308021902453652\n"
        + "10110106501002023080219004136121\n"
        + "10110106501002023080218541897368\n"
        + "10110106501002023080216443363593\n"
        + "10110106501002023080215522738135\n"
        + "10110106501002023080212483080200\n"
        + "1011010650100202308021222415833\n"
        + "10110106501002023080212202064442\n"
        + "10110106501002023080211572656925\n"
        + "10110106501002023080211042021946\n"
        + "10110106501002023080210261151203\n"
        + "10110106501002023080119260696463\n"
        + "10110106501002023080114313163371\n"
        + "1011010650100202307311946019059\n"
        + "10110106501002023073114201787260\n"
        + "10110106501002023073101483612770\n"
        + "10110106501002023072817313449317\n"
        + "10110106501002023072812471811881\n"
        + "10110106501002023072811524430343\n"
        + "10110106501002023072811054632803\n"
        + "10110106501002023072810202118772\n"
        + "10110106501002023072810145086521\n"
        + "10110106501002023072719272719937\n"
        + "10110106501002023072719242399234\n"
        + "10110106501002023072713123073086\n"
        + "101101065010020230727124256982\n"
        + "10110106501002023072711274224311\n"
        + "10110106501002023072710151586308\n"
        + "10110106501002023072617250943234\n"
        + "10110106501002023072616082296792\n"
        + "10110106501002023072612495188223\n"
        + "10110106501002023072612345751205\n"
        + "10110106501002023072610261490972\n"
        + "10110106501002023072518270996711\n"
        + "10110106501002023072516520747955\n"
        + "1011010650100202307251619514253\n"
        + "10110106501002023072516015850044\n"
        + "1011010650100202307251552279691\n"
        + "10110106501002023072423263211021\n"
        + "10110106501002023072414502270819\n"
        + "10110106501002023072411560118283\n"
        + "10110106501002023072411421524993\n"
        + "1011010650100202307241130414144\n"
        + "10110106501002023072411091849131\n"
        + "10110106501002023072410543982730\n"
        + "10110106501002023072410442134508\n"
        + "10110106501002023072410391042279\n"
        + "10110106501002023072410252951381\n"
        + "10110106501002023072410100190047\n"
        + "10110106501002023072409310845460\n"
        + "1011010650100202307240831405541\n"
        + "10110106501002023072117452350618\n"
        + "1011010650100202307211707448697\n"
        + "10110106501002023072016552827629\n"
        + "1011010650100202307201653366091\n"
        + "10110106501002023072016524174984\n"
        + "10110106501002023072016484332847\n"
        + "10110106501002023072016325285558\n"
        + "10110106501002023072012510282991\n"
        + "10110106501002023071713453242878\n"
        + "10110106501002023071711474467193\n"
        + "10110106501002023071710450723634\n"
        + "10110106501002023071612343470211\n"
        + "10110106501002023071514370189687\n"
        + "10110106501002023071317570793080\n"
        + "10110106501002023071314312816863\n"
        + "10110106501002023071314261099518\n"
        + "1011010650100202307121703471455\n"
        + "10110106501002023071213362370919\n"
        + "1011010650100202307121306375270\n"
        + "10110106501002023071212423776373\n"
        + "10110106501002023071210195469638\n"
        + "10110106501002023071111194033275\n"
        + "1011010650100202307111118038808\n"
        + "1011010650100202307110932236351\n"
        + "10110106501002023071018502060506\n"
        + "10110106501002023071016270834736\n"
        + "10110106501002023071015240318008\n"
        + "10110106501002023070914085245361\n"
        + "10110106501002023070713320927278\n"
        + "10110106501002023070616244487222\n"
        + "10110106501002023070615384538080\n"
        + "1011010650100202307051749134107\n"
        + "10110106501002023070517425280144\n"
        + "10110106501002023070517195525938\n"
        + "10110106501002023070508282031985\n"
        + "10110106501002023070417330876816\n"
        + "10110106501002023070416432458485\n"
        + "1011010650100202307041331595000\n"
        + "10110106501002023070413231632747\n"
        + "10110106501002023070412063018712\n"
        + "10110106501002023070411232617369\n"
        + "10110106501002023070317272422433\n"
        + "10110106501002023070317271049838\n"
        + "10110106501002023070317264516593\n"
        + "10110106501002023070317252926819\n"
        + "10110106501002023070317234996830\n"
        + "10110106501002023070317215936320\n"
        + "10110106501002023070317150032793\n"
        + "10110106501002023070316360372355\n"
        + "10110106501002023070315240514558\n"
        + "1011010650100202307031450596971\n"
        + "1011010650100202307031303567836\n"
        + "10110106501002023070311143572217\n"
        + "10110106501002023070310493337072\n"
        + "10110106501002023070223092999892\n"
        + "10110106501002023070219492919216\n"
        + "1011010650100202307011554509655\n"
        + "10110106501002023063018350359869\n"
        + "10110106501002023063017174988071\n"
        + "10110106501002023062911054521844\n"
        + "10110106501002023062910561024772\n"
        + "10110106501002023062816121978715\n"
        + "10110106501002023062816063850601\n"
        + "10110106501002023062815502423980\n"
        + "10110106501002023062815170659013\n"
        + "10110106501002023062720100712831\n"
        + "10110106501002023062719530762246\n"
        + "10110106501002023062719513131941\n"
        + "10110106501002023062719482324005\n"
        + "10110106501002023062719392315499\n"
        + "10110106501002023062719350351810\n"
        + "10110106501002023062719151587932\n"
        + "10110106501002023062716060358723\n"
        + "10110106501002023062715365647679\n"
        + "1011010650100202306271535282504\n"
        + "10110106501002023062714333983575\n"
        + "10110106501002023062714152395990\n"
        + "10110106501002023062713051481563\n"
        + "10110106501002023062712552331701\n"
        + "10110106501002023062712535685809\n"
        + "10110106501002023062712242898181\n"
        + "10110106501002023062712031282694\n"
        + "10110106501002023062711524766438\n"
        + "1011010650100202306271050222663\n"
        + "10110106501002023062710211814486\n"
        + "10110106501002023062709522386909\n"
        + "10110106501002023062708441890404\n"
        + "10110106501002023062619462564426\n"
        + "10110106501002023062617405571230\n"
        + "10110106501002023062616544090872\n"
        + "10110106501002023062615215988617\n"
        + "10110106501002023062615154171959\n"
        + "10110106501002023062615140065766\n"
        + "10110106501002023062613341039668\n"
        + "10110106501002023062613312146483\n"
        + "1011010650100202306261235533070\n"
        + "10110106501002023062612333782967\n"
        + "10110106501002023062612070628832\n"
        + "10110106501002023062611371317492\n"
        + "10110106501002023062611371249173\n"
        + "10110106501002023062610543641116\n"
        + "1011010650100202306251815341279\n"
        + "10110106501002023062518045156470\n"
        + "10110106501002023062517413116675\n"
        + "10110106501002023062517000293171\n"
        + "10110106501002023062516130539242\n"
        + "10110106501002023062516001051220\n"
        + "10110106501002023062511595964316\n"
        + "10110106501002023062511483848829\n"
        + "10110106501002023062511480551348\n"
        + "10110106501002023062510542086232\n"
        + "10110106501002023062510212995054\n"
        + "10110106501002023062417023360510\n"
        + "10110106501002023062316385929931\n"
        + "10110106501002023062315121185372\n"
        + "10110106501002023062122312296599\n"
        + "10110106501002023062120093324469\n"
        + "10110106501002023062118483261247\n"
        + "10110106501002023062118404782208\n"
        + "10110106501002023062117224782420\n"
        + "10110106501002023062117194059396\n"
        + "10110106501002023062117154238698\n"
        + "10110106501002023062117085766890\n"
        + "10110106501002023062116321431493\n"
        + "10110106501002023062116242336869\n"
        + "1011010650100202306211622137192\n"
        + "10110106501002023062116202679424\n"
        + "1011010650100202306211619209178\n"
        + "10110106501002023062116190924709\n"
        + "10110106501002023062116161851386\n"
        + "1011010650100202306211344442457\n"
        + "10110106501002023062112431290478\n"
        + "10110106501002023062111072622127\n"
        + "10110106501002023062110391680632\n"
        + "10110106501002023062110334041666\n"
        + "10110106501002023062110233744359\n"
        + "10110106501002023062110101413714\n"
        + "10110106501002023062110083634238\n"
        + "10110106501002023062018003014554\n"
        + "10110106501002023062013500268001\n"
        + "10110106501002023062012113770369\n"
        + "10110106501002023062010031112723\n"
        + "10110106501002023061918290347196\n"
        + "10110106501002023061917111249708\n"
        + "10110106501002023061917003311696\n"
        + "10110106501002023061912464537915\n"
        + "10110106501002023061911530923471\n"
        + "10110106501002023061911453787431\n"
        + "10110106501002023061911440595958\n"
        + "10110106501002023061717201487401\n"
        + "10110106501002023061710044560037\n"
        + "10110106501002023061619451830134\n"
        + "10110106501002023061618424857443\n"
        + "10110106501002023061618330916590\n"
        + "10110106501002023061612134967690\n"
        + "10110106501002023061611514219655\n"
        + "10110106501002023061611424753899\n"
        + "10110106501002023061611160841256\n"
        + "10110106501002023061611135699962\n"
        + "10110106501002023061518565652186\n"
        + "10110106501002023061516244272727\n"
        + "10110106501002023061513075164667\n"
        + "10110106501002023061512342469461\n"
        + "10110106501002023061512255388976\n"
        + "1011010650100202306151124473283\n"
        + "10110106501002023061510151085569\n"
        + "10110106501002023061417410253296\n"
        + "10110106501002023061412450447893\n"
        + "10110106501002023061412321429720\n"
        + "10110106501002023061412244555194\n"
        + "10110106501002023061412044517639\n"
        + "10110106501002023061411512072411\n"
        + "1011010650100202306141151019797\n"
        + "10110106501002023061411463897505\n"
        + "10110106501002023061410541332158\n"
        + "10110106501002023061410533190242\n"
        + "10110106501002023061317295836713\n"
        + "10110106501002023061316471461007\n"
        + "10110106501002023061316370635105\n"
        + "10110106501002023061316192997135\n"
        + "10110106501002023061316112555540\n"
        + "10110106501002023061313242470872\n"
        + "10110106501002023061311391337504\n"
        + "10110106501002023061311363091738\n"
        + "10110106501002023061310240110941\n"
        + "10110106501002023061310084094327\n"
        + "10110106501002023061218453545629\n"
        + "10110106501002023061217534877139\n"
        + "10110106501002023061215152594780\n"
        + "10110106501002023061213493039835\n"
        + "10110106501002023061212563467420\n"
        + "10110106501002023061212215455669\n"
        + "10110106501002023061212084513896\n"
        + "101101065010020230612112652285\n"
        + "10110106501002023061211092310967\n"
        + "10110106501002023061210430921594\n"
        + "10110106501002023061210192618675\n"
        + "10110106501002023061121404280830\n"
        + "10110106501002023061020203732097\n"
        + "10110106501002023060911532170521\n"
        + "10110106501002023060911003564521\n"
        + "10110106501002023060823193471357\n"
        + "10110106501002023060823193475109\n"
        + "10110106501002023060819084891490\n"
        + "10110106501002023060812134977668\n"
        + "10110106501002023060810201661082\n"
        + "10110106501002023060809295159566\n"
        + "10110106501002023060807532131797\n"
        + "10110106501002023060717585570582\n"
        + "10110106501002023060711375129602\n"
        + "10110106501002023060618033446099\n"
        + "10110106501002023060617223698729\n"
        + "10110106501002023060616553383995\n"
        + "10110106501002023060615130310634\n"
        + "10110106501002023060519145040505\n"
        + "10110106501002023060517341680444\n"
        + "10110106501002023060517324486275\n"
        + "10110106501002023060517080031632\n"
        + "10110106501002023060512230920848\n"
        + "10110106501002023060512134284559\n"
        + "10110106501002023060510291062482\n"
        + "10110106501002023060216481136456\n"
        + "10110106501002023060213144578980\n"
        + "10110106501002023060212280574864\n"
        + "10110106501002023060210163574815\n"
        + "10110106501002023060118280223148\n"
        + "10110106501002023060117472429546\n"
        + "10110106501002023060116034012156\n"
        + "10110106501002023060115493264308\n"
        + "10110106501002023060112163234573\n"
        + "10110106501002023060112154012512\n"
        + "10110106501002023060112122312748\n"
        + "10110106501002023060111521029076\n"
        + "10110106501002023060111234869108\n"
        + "10110106501002023060110544880211\n"
        + "10110106501002023060108134961106";



    Arrays.stream(ids.split("\n")).forEach(orderSerialNo -> {
    HashMap hashMap = new HashMap();
    hashMap.put("serialNo", orderSerialNo);
    String requestBody = JacksonUtils.obj2JsonString(hashMap);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<>(requestBody, headers);
    String url = "https://xjbt-jy.gongbao.cn/eg-service/tool/updateUserOneById";
    String responseMsg = getRestTemplate().postForObject(url, param, String.class);
    System.out.println("orderSerialNo ========" + orderSerialNo);
    System.out.println("res ===== " + responseMsg);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

  public static RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(Duration.ofMinutes(3)).setReadTimeout(
        Duration.ofMinutes(3)).build();

    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
        StandardCharsets.UTF_8);
    stringHttpMessageConverter.setWriteAcceptCharset(true);

    List<MediaType> mediaTypeList = new ArrayList<>();
    mediaTypeList.add(MediaType.ALL);

    for (int i = 0; i < restTemplate.getMessageConverters().size(); i++) {
      HttpMessageConverter<?> httpMessageConverter = restTemplate.getMessageConverters().get(i);
      if (httpMessageConverter instanceof StringHttpMessageConverter) {
        restTemplate.getMessageConverters().remove(i);
        restTemplate.getMessageConverters().add(i, stringHttpMessageConverter);
      } else if(httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
        try{
          ((MappingJackson2HttpMessageConverter) httpMessageConverter).setSupportedMediaTypes(mediaTypeList);
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
    ClientHttpRequestFactory requestFactory = null;
    TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
          public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
          }
          public void checkClientTrusted(
              X509Certificate[] certs, String authType) {
          }
          public void checkServerTrusted(
              X509Certificate[] certs, String authType) {
          }
        }
    };
    SSLContext sslContext = null;
    HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
    try {
      sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
      CloseableHttpClient httpClient = HttpClients.custom()
          .setSSLContext(sslContext)
          .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
          .build();
      customRequestFactory.setHttpClient(httpClient);
    } catch (Exception e) {
      e.printStackTrace();
    }
    requestFactory = (ClientHttpRequestFactory)customRequestFactory;
    restTemplate.setRequestFactory(requestFactory);
    return restTemplate;
  }

}