### Exception 코드 정의
<table>
    <tr>
        <th>Http Status</th>
        <th>상태내용</th>
        <th>코드</th>
        <th>메시지</th>
    </tr>
    <tr>
        <td>200</td>
        <td>성공</td>
        <td>SU</td>
        <td>Success.</td>
    </tr>
    <tr>
        <td rowspan=3>400</td>
        <td>유효성 검증 실퍠</td>
        <td>VF</td>
        <td>Validation failed.</td>
    </tr>
    <tr>
        <td>중복된 ID</td>
        <td>DI</td>
        <td>Duplicate ID.</td>
    </tr>
    <tr>
        <td>존재하지 않는 사용자</td>
        <td>NU</td>
        <td>This user does not exist.</td>
    </tr>
    <tr>
        <td rowspan=2>401</td>
        <td>로그인 실패</td>
        <td>SF</td>
        <td>Login infomation mismatch.</td>
    </tr>
    <tr>
        <td>인증 실퍠</td>
        <td>AF</td>
        <td>Authorization Failed.</td>
    </tr>
    <tr>
        <td>403</td>
        <td>권한 없음</td>
        <td>NP</td>
        <td>Do not have permission.</td>
    </tr>
    <tr>
        <td>500</td>
        <td>데이터 베이스 에러</td>
        <td>DBE</td>
        <td>Database Error.</td>
    </tr>
</table>