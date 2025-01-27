/**
 * 버그
 */
export interface Bug {
    rowNumber: number;
    projectName: string;
    categoryName: string;
    summary: string;
    status: string;
    reporterId: string;
    handlerId: string;
    handlerName: string;
    dataSubmitted: string;
}

/**
 * 사용자
 */
export interface User {
    id: string;
    name: string;
}