/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* asteroidCollision(int* asteroids, int asteroidsSize, int* returnSize) {
    int* answer = (int*)malloc(asteroidsSize * sizeof(int)); // stack
    int tos = 0; // top of stack
    bool isBroken;
    for(int i=0; i<asteroidsSize; i++) {
        int astero = asteroids[i];
        isBroken = false;
        if(astero < 0) {
            while(tos > 0 && answer[tos - 1] > 0) {
                if(answer[tos - 1] + astero > 0) {
                    isBroken = true;
                    break;
                } else if(answer[tos - 1] + astero == 0) {
                    tos--;
                    isBroken = true;
                    break;
                } else {
                    tos--;
                }
            }
            if(!isBroken) {
                answer[tos++] = astero;
            }
        } else {
            answer[tos++] = astero;
        }
    }
    *returnSize = tos;
    return answer;
}